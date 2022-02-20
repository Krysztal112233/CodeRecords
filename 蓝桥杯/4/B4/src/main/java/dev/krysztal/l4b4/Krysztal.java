package dev.krysztal.l4b4;

import java.math.BigInteger;

public class Krysztal {

    public static void main(String[] args) {
        BigInteger first = BigInteger.ONE;
        BigInteger secon = BigInteger.ONE;
        BigInteger num100 = BigInteger.ZERO;
        // 斐波那契数列
        // 能通过斐波那契数列计算黄金数,原理为相邻两数小的除大的
        for (int i = 1; i < 100000; i++) {
            BigInteger res = first.add(secon);
            first = secon;
            secon = res;
        }
        // 当相邻的斐波那契数取比较大的数目时，算出来的黄金数更加精确
        for (int i = 0; i < 102; i++) {
            BigInteger ans = first.divide(secon);
            first = first.mod(secon).multiply(BigInteger.TEN);

            // 储存第100位
            if (i == 100)
                num100 = ans;

            // 处理四舍五入，需要额外计算一次也就是计算 101 次
            if (i == 101)
                if (ans.compareTo(BigInteger.valueOf(5)) != -1)
                    num100 = num100.add(BigInteger.valueOf(1));

            // 跳过第一位输出
            if (i == 0)
                continue;
            System.out.print(i != 0 && i < 100 ? ans : num100);
        }
    }

}
