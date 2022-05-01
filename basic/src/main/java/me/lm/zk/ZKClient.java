package me.lm.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * zk client use case
 *
 * @author bule_ann
 * @since 2022/4/4
 */
public class ZKClient {

    private ZooKeeper zkClient;

    public static void main(String[] args) {
    }

    @Before
    public void init() {
        String connectString = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
        int sessionTimeout = 100;
        try {
            zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    getChildren();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create() {
        try {
            String nodeCreated = zkClient.create("/lm", "cc dog".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getChildren() {
        try {
            List<String> children = zkClient.getChildren("lm", true);
            children.forEach(System.out::println);
            System.out.println("-------------------");
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exist() {
        try {
            Stat exists = zkClient.exists("/lm", false);
            System.out.println(exists == null ? "null" : "exist");
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
