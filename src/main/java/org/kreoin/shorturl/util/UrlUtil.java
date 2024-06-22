package org.kreoin.shorturl.util;

import static java.lang.Math.random;

public class UrlUtil {
    private static final char[] alphabet = "23456789abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int urlSize = 6;
    private static final int base = alphabet.length;

    public static Long generate() {
        double size = Math.pow(base, urlSize);
        return (long) (random()*size);
    }

    public static String generateToken() {
        var shortUrl = new StringBuilder();
        var generatedNum = generate();
        for (int i = 0; i < urlSize; i++) {
            int mod = (int) (generatedNum % base);
            generatedNum /= base;
            shortUrl.append(alphabet[mod]);
        }
        return shortUrl.toString();
    }

}
