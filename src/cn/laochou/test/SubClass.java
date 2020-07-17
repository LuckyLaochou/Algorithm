package cn.laochou.test;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/15 0015 16:58
 * @Version: 1.0
 */
public class SubClass extends AbsClass {

    public void test() {
        super.hello();
    }


    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.test();
    }

}
