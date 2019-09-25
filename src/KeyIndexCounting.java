/*Counting Sort
    not a comparision based sorting algorithm
    O(n + r)
 */

import java.util.Scanner;

public class KeyIndexCounting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char a[] = s.toCharArray();
        int n = s.length();
        int r = 256;
        int count[] = new int[r + 1];
        char aux[] = new char[n];

        //counting frequency
        for (int i = 0; i < n; i++) {
            count[a[i] + 1]++;
        }

        // computing cumulative
        // a = count[i] : there are a keys less than the key i
        for (int i = 0; i < r; i++) {
            count[i + 1] += count[i];
        }

        //move items
        for (int i = 0; i < n; i++) {
            aux[count[a[i]]++] = a[i];
        }

        for (int i = 0; i < n; i++) {
            a[i] = aux[i];
        }
        String p = new String(a);
        System.out.println(p);
    }
}
