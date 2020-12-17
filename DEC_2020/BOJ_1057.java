package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1057 {
    static int num;
    static int kim;
    static int lim;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        num = Integer.parseInt(st[0]);
        kim = Integer.parseInt(st[1]);
        lim = Integer.parseInt(st[2]);
        System.out.println(solve());
    }

    public static int solve() {
        int round = 0;

        while (kim != lim) {
            kim = kim / 2 + kim % 2;
            lim = lim / 2 + lim % 2;
            round++;
        }

        return round;
    }
}