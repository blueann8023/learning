package me.lm.zuul2;

import com.google.inject.Injector;
import com.netflix.config.ConfigurationManager;
import com.netflix.governator.InjectorBuilder;
import com.netflix.zuul.netty.server.BaseServerStartup;
import com.netflix.zuul.netty.server.Server;


public class Bootstrap {

    public static void main(String[] args) {
        new Bootstrap().start();
    }

    public void start() {
        System.out.println("Zuul Sample: starting up.");
        long startTime = System.currentTimeMillis();
        int exitCode = 0;

        Server server = null;

        try {
            // 读取properties配置
            ConfigurationManager.loadCascadedPropertiesFromResources("application");
            // IOC容器依赖注入
            Injector injector = InjectorBuilder.fromModule(new ZuulSampleModule()).createInjector();
            BaseServerStartup serverStartup = injector.getInstance(BaseServerStartup.class);
            // 获取已构建的服务
            server = serverStartup.server();

            long startupDuration = System.currentTimeMillis() - startTime;
            System.out.println("Zuul Sample: finished startup. Duration = " + startupDuration + " ms");
            // 启动服务
            server.start(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("###############");
            System.err.println("Zuul Sample: initialization failed. Forcing shutdown now.");
            System.err.println("###############");
            exitCode = 1;
        } finally {
            // server shutdown
            if (server != null) server.stop();

            System.exit(exitCode);
        }
    }
}
