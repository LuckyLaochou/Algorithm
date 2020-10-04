package cn.laochou.day924.one;

public class NameValid extends AbstractValid{

    public NameValid(String condition) {
        super(condition);
    }

    @Override
    public boolean condition() {
        return condition.equals("群硕软件开发有限公司");
    }
}
