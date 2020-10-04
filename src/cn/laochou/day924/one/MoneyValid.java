package cn.laochou.day924.one;

public class MoneyValid extends AbstractValid {
    public MoneyValid(String condition) {
        super(condition);
    }

    @Override
    public boolean condition() {
        int number = Integer.parseInt(condition);
        return number <= 10000;
    }
}
