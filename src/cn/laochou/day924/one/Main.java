package cn.laochou.day924.one;

public class Main {

    public static void main(String[] args) {
        AbstractValid valid = new MoneyValid("10000");
        valid.nextValid = new DayValid("30");
        valid.nextValid.nextValid = new NameValid("群硕软件开发有限公司");
        System.out.println(valid.valid());

    }

}
