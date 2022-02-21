package dev.krysztal.l4b5;

public class Krysztal {
    public static void main(String[] args) {
        KrysztalCodes a = new KrysztalCodes(1, 3);
        KrysztalCodes b = new KrysztalCodes(1, 6);
        KrysztalCodes c = a.add(b);
        System.out.println(a + "+" + b + "=" + c);
    }
}
