package me.lm.zuul2;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.config.DynamicIntProperty;
import com.netflix.discovery.EurekaClient;
import com.netflix.netty.common.accesslog.AccessLogPublisher;
import com.netflix.netty.common.channel.config.ChannelConfig;
import com.netflix.netty.common.channel.config.CommonChannelConfigKeys;
import com.netflix.netty.common.metrics.EventLoopGroupMetrics;
import com.netflix.netty.common.proxyprotocol.StripUntrustedProxyHeadersHandler;
import com.netflix.netty.common.status.ServerStatusManager;
import com.netflix.spectator.api.Registry;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.FilterUsageNotifier;
import com.netflix.zuul.RequestCompleteHandler;
import com.netflix.zuul.context.SessionContextDecorator;
import com.netflix.zuul.netty.server.BaseServerStartup;
import com.netflix.zuul.netty.server.DirectMemoryMonitor;
import com.netflix.zuul.netty.server.ZuulServerChannelInitializer;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.group.ChannelGroup;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class SampleServerStartup extends BaseServerStartup {

    enum ServerType {
        HTTP,
        HTTP2,
        HTTP_MUTUAL_TLS,
        WEBSOCKET,
        SSE
    }

    private static final ServerType SERVER_TYPE = ServerType.HTTP;

    @Inject
    public SampleServerStartup(ServerStatusManager serverStatusManager, FilterLoader filterLoader,
                               SessionContextDecorator sessionCtxDecorator, FilterUsageNotifier usageNotifier,
                               RequestCompleteHandler reqCompleteHandler, Registry registry,
                               DirectMemoryMonitor directMemoryMonitor, EventLoopGroupMetrics eventLoopGroupMetrics,
                               EurekaClient discoveryClient, ApplicationInfoManager applicationInfoManager,
                               AccessLogPublisher accessLogPublisher) {
        super(serverStatusManager, filterLoader, sessionCtxDecorator, usageNotifier, reqCompleteHandler, registry,
                directMemoryMonitor, eventLoopGroupMetrics, discoveryClient, applicationInfoManager,
                accessLogPublisher);
    }

    @Override
    protected Map<Integer, ChannelInitializer> choosePortsAndChannels(
            ChannelGroup clientChannels,
            ChannelConfig channelDependencies) {
        // 放入到ChannelPipeline中的渠道信息
        Map<Integer, ChannelInitializer> portsToChannels = new HashMap<>();
        // 获取Zuul服务的启动端口，默认为7001
        int port = new DynamicIntProperty("zuul.server.port.main", 7001).get();
        // 首先加载默认的Channel配置
        ChannelConfig channelConfig = BaseServerStartup.defaultChannelConfig();
        // 下面这些配置的调整依赖于你是否在ELB Http监听器、TCP监听器或者直接放在互联网上
        switch (SERVER_TYPE) {
            /* The below settings can be used when running behind an ELB HTTP listener that terminates SSL for you
             * and passes XFF headers.
             */
            case HTTP:
                channelConfig.set(CommonChannelConfigKeys.allowProxyHeadersWhen, StripUntrustedProxyHeadersHandler.AllowWhen.ALWAYS);
                channelConfig.set(CommonChannelConfigKeys.preferProxyProtocolForClientIp, false);
                channelConfig.set(CommonChannelConfigKeys.isSSlFromIntermediary, false);
                channelConfig.set(CommonChannelConfigKeys.withProxyProtocol, false);

                portsToChannels.put(port, new ZuulServerChannelInitializer(port, channelConfig, channelDependencies, clientChannels));
                logPortConfigured(port, null);
                break;

            /* The below settings can be used when running behind an ELB TCP listener with proxy protocol, terminating
             * SSL in Zuul.
             */
            case HTTP2:
                break;

            /* The below settings can be used when running behind an ELB TCP listener with proxy protocol, terminating
             * SSL in Zuul.
             *
             * Can be tested using certs in resources directory:
             *  curl https://localhost:7001/test -vk --cert src/main/resources/ssl/client.cert:zuul123 --key src/main/resources/ssl/client.key
             */
            case HTTP_MUTUAL_TLS:
                break;

            /* Settings to be used when running behind an ELB TCP listener with proxy protocol as a Push notification
             * server using WebSockets */
            case WEBSOCKET:
                break;

            /* Settings to be used when running behind an ELB TCP listener with proxy protocol as a Push notification
             * server using Server Sent Events (SSE) */
            case SSE:
                break;
        }

        return portsToChannels;
    }

    private File loadFromResources(String s) {
        return new File(ClassLoader.getSystemResource("ssl/" + s).getFile());
    }
}
