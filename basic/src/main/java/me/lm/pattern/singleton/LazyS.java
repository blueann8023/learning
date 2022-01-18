package me.lm.pattern.singleton;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/10
 */
public class LazyS {

    private LazyS() {
    }

    private static LazyS instance;
    public LazyS getInstance() {//有并发问题
        if (instance == null) {
            instance = new LazyS();
        }
        return instance;
    }

    private static LazyS instanceWithLock;
    public synchronized LazyS getInstanceWithLock() {
        if (instanceWithLock == null) {
            instanceWithLock = new LazyS();
        }
        return instanceWithLock;
    }

    private static LazyS instanceWithCL;
    public LazyS getInstanceWithCheckLock() {
        if (instanceWithCL == null) {
            synchronized (LazyS.class) {//有半初始化导致的并发问题
                instanceWithCL = new LazyS();
            }
        }
        return instanceWithCL;
    }

    private static LazyS instanceWithDCL;
    public LazyS getInstanceWithDCL() {
        if (instanceWithDCL == null) {
            synchronized (LazyS.class) {
                if (instanceWithDCL == null) {
                    instanceWithDCL = new LazyS(); //Double Check Lock 有指令重排问题
                }
            }
        }
        return instanceWithDCL;
    }

    private static volatile LazyS instanceWithDCLSafe;
    public LazyS getInstanceWithDCLSafe() {
        if (instanceWithDCLSafe == null) {
            synchronized (LazyS.class) {
                if (instanceWithDCLSafe == null) {
                    instanceWithDCLSafe = new LazyS();
                }
            }
        }
        return instanceWithDCLSafe;
    }
}
