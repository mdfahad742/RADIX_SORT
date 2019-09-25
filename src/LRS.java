/**
 * Longest Repeating substring
 */

import java.util.*;

public class LRS {
    public static int lcp(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length());
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return i;
        }
        return n;
    }

    public static String lrs(String s) {
        int N = s.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++)
            suffixes[i] = s.substring(i, N);
        Arrays.sort(suffixes);
        String lrs = "";
        for (int i = 0; i < N - 1; i++) {
            int len = lcp(suffixes[i], suffixes[i + 1]);
            if (len > lrs.length())
                lrs = suffixes[i].substring(0, len);
        }
        return lrs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(lrs(s));
    }
}
