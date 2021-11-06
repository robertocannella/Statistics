package com.robertocannella;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);


    int N = scanner.nextInt();
    List<Integer> W = new ArrayList<>(N);
    List<Integer> X = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            X.add(scanner.nextInt());
        }
        for (int i = 0; i < N; i++) {
            W.add(scanner.nextInt());
        }


        scanner.close();

        Statistics.weightedMean(X,W);

    }


}
