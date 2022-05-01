package me.lm.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/4/5
 */
public class DixLock {


    private final String cs = "localhost:2181,localhost:2182,localhost:2183";
    private final int st = 3000;
    private ZooKeeper zk;

    private CountDownLatch connect = new CountDownLatch(1);
    private CountDownLatch lock = new CountDownLatch(1);

    public DixLock() throws IOException, InterruptedException, KeeperException {
        // 连接
        zk = new ZooKeeper(cs, st, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                connect.countDown();
            }
        });

        // 等待连接
        connect.await();

        // 创建/locks 目录
        Stat exists = zk.exists("/locks", false);// 会有并发问题哈
        if (exists == null) {
            zk.create("/locks", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

    }

    public void zkLock() throws InterruptedException, KeeperException {
        String name = zk.create("/locks/seq-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        List<String> children = zk.getChildren("/locks", false);

        if (children.size() == 1) {
            return;
        }

        int index = children.indexOf(name.substring("/locks/".length()));
        if (index == -1) {
            System.out.println("异常");
        } else if (index == 0) {
            return;
        } else {
            String waitPath = "/locks/" + children.get(index - 1);
            zk.getData(waitPath, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getType()== Event.EventType.NodeDeleted && watchedEvent.getPath().equals("111"))
                        lock.countDown();
                }
            },null);
            lock.await();
        }
    }

    public void zkUnlock() {

    }
    
    
}
