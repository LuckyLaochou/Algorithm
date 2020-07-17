package cn.laochou.day630.单例模式;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/30 0030 12:57
 * @Version: 1.0
 */
public class DoubleCheck {


    private static DoubleCheck instance = null;


    private static final Object lock = new Object();


    private DoubleCheck() {}


    public static DoubleCheck getInstance() {
        if(instance == null) {
            synchronized (lock) {
                if(instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }

}
