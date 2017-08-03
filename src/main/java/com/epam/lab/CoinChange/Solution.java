package com.epam.lab.CoinChange;
import java.util.*;

public class Solution {


    public static long makeChange(int[] coins, int money) {
        return 1L;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n < 1 || n > 200){
            throw new IllegalArgumentException();
        }
        if (m < 1 || m > 50){
            throw new IllegalArgumentException();
        }
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}