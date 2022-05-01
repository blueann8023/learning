package me.lm.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/4/4
 */
public class DixClient {
    private String connectString = "";
    private int sessionTimeout = 2000;
    private ZooKeeper zooKeeper;
    private List<String> servers = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, KeeperException {
        DixClient dixClient = new DixClient();
        dixClient.getServerList();
        dixClient.biz();

    }

    private void getServerList() throws InterruptedException, KeeperException {
        List<String> children = zooKeeper.getChildren("/servers", true);
        children.forEach(child -> {
            try {
                byte[] data = zooKeeper.getData("/servers/" + child, false, null);
                servers.add(new String(data));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void biz() {
    }

    private void connect() throws IOException {

        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    getServerList();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (KeeperException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
