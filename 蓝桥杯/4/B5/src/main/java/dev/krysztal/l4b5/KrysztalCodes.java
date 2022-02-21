
package dev.krysztal.l4b5;

public class KrysztalCodes {
    // 分子
    private long molecular;
    // 分母
    private long denominator;

    // 计算最大公约数
    // 算法为辗转相除法
    private long cGreatestCommonDivisor(long molecular, long denominator) {
        if (denominator == 0)
            return molecular;
        return cGreatestCommonDivisor(denominator, molecular % denominator);
    }

    // 初始化数据
    public KrysztalCodes(long molecular, long denominator) {
        this.molecular = molecular;
        this.denominator = denominator;
        long gcd = cGreatestCommonDivisor(molecular, denominator);
        if (gcd > 1) {
            // gcd为最大公约数
            // 约分处理
            molecular /= gcd;
            denominator /= gcd;
        }
    }

    // 加法
    public KrysztalCodes add(KrysztalCodes x) {
        return new KrysztalCodes(x.molecular * denominator + molecular * x.denominator, x.denominator * denominator); // 填空位置
    }

    // 乘法
    public KrysztalCodes mul(KrysztalCodes x) {
        return new KrysztalCodes(molecular * x.molecular, denominator * x.denominator);
    }

    public String toString() {
        if (denominator == 1)
            return "" + molecular;
        return molecular + "/" + denominator;
    }
}
