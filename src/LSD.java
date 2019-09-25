/**
 *Least-significant-digit-first string sort(Radix Sort)
 * LSD sorts fixed-length strings in ascending order
 * LSD sort is stable.
 * Non-Comparision Based Sorting
 *
 * Sort one million 32-bit integers.?
 * LSD string sort.
 * O(w * n)
 */

import java.util.Arrays;
import java.util.Scanner;
public class LSD {

    public static void sort(String[] a, int W) { // fixed length W string
        int r = 256; // Radix R
        int n = a.length;
        String[] aux = new String[n];
        for (int i = W - 1; i >= 0; i--) { // do key-indexed counting for each digit from right to left
            int count[] = new int[r + 1];
            for (int j = 0; j < n; j++) {
                count[a[j].charAt(i) + 1]++;
            }
            for (int j = 0; j < r; j++) {
                count[j + 1] += count[j];
            }
            for (int j = 0; j < n; j++) {
                aux[count[a[j].charAt(i)]++] = a[j];
            }
            for (int j = 0; j < n; j++) {
                a[j] = aux[j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        String s[] = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sort(s, W);
        System.out.println(Arrays.toString(s));
    }
}
