package cn.laochou.day924.one;

public class DayValid extends AbstractValid {

    public DayValid(String condition) {
        super(condition);
    }

    @Override
    public boolean condition() {
        int number = Integer.parseInt(condition);
        return number <= 30;
    }
}
