package cn.laochou.day913_jiji;
public class One {
    private int canLive = 0;
    public int getMaxCanLive(int money, int[] prices) {
        dfs(money, prices, 0);
        return canLive == 0 ? -1 : canLive;
    }
    private void dfs(int money, int[] prices, int live) {
        if(money < 0) {
            return;
        }
        if(money == 0) {
            canLive = Math.max(canLive, live);
            return;
        }
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > money) {
                continue;
            }
            dfs(money - prices[i], prices, live + 1);
        }
    }
    public static void main(String[] args) {
        One one = new One();
        System.out.println(one.getMaxCanLive(1000, new int[]{1001, 1000, 300, 700}));
    }

}
