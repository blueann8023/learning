package me.lm.zk;

import org.apache.zookeeper.ZooKeeper;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/4/4
 */
public class DixServer {

    private ZooKeeper zkClient;

    public static void main(String[] args) {
        DixServer dixServer = new DixServer();
        dixServer.getConnect();
        dixServer.register();
        dixServer.biz();
    }

    private void getConnect() {
    }

    private void register() {

    }

    private void biz() {
    }
}
