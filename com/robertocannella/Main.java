package com.robertocannella;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int [] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        float mean = Statistics.mean(numbers);
        float median = Statistics.median(numbers);
        int modal = Statistics.mode(numbers);
       // System.out.println(Arrays.toString(numbers));
        System.out.println(mean);
        System.out.println(median);
        System.out.println(modal);


    }


}
