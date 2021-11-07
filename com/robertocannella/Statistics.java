package com.robertocannella;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {
    public static void interQuartile(List<Integer> values, List<Integer> freqs) {
        // Print your answer to 1 decimal place within this function
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < freqs.size(); i++) {
            for (int j = 0; j < freqs.get(i) ; j++) {
                arr.add(values.get(i));
            }
        }
        List<Float> quartiles = quartiles(arr);

        System.out.println((float)quartiles.get(2)-quartiles.get(0));

    }
    public static List<Float> quartiles(List<Integer> arr) {
        // Write your code here
        List<Float> Qs = new ArrayList<>();
        Collections.sort(arr);
        if (arr.size()%2 == 0){
            List<Integer> lower = new ArrayList<>(arr.subList(0,arr.size()/2));
            List<Integer> upper = new ArrayList<>(arr.subList(arr.size()/2,arr.size()));
            Qs.add((float)median(lower));
            Qs.add((float)median(arr));
            Qs.add((float)median(upper));

            return Qs;
        }

        List<Integer> lower = new ArrayList<>(arr.subList(0,arr.size()/2));
        List<Integer> upper = new ArrayList<>(arr.subList(arr.size()/2 + 1,arr.size()));
        Qs.add((float)median(lower));
        Qs.add((float)median(arr));
        Qs.add((float)median(upper));

        return Qs;
    }
    public static void weightedMean(List<Integer> X, List<Integer> W) {
        double totalWeight = W.stream().mapToDouble(v -> v).sum();
        double productWX = 0;

        for (int i = 0; i < X.size(); i++) {
            double calc = X.get(i) * W.get(i);
            productWX += calc;
        }
        System.out.printf("%.1f",productWX/totalWeight);
    }
    public static float median(List<Integer> arr){
        Collections.sort(arr);
        if (arr.size()%2 ==0){
            int value1 = arr.get(arr.size()/2);
            int value2 = arr.get((arr.size()/2)-1);
            return ((float)(value1+value2)/2);
        }
        return arr.get(arr.size()/2);
    }

    public static float median(int[] numbers){
        List<Integer> list = Arrays.stream(numbers)        // IntStream
                                    .boxed()          // Stream<Integer>
                                    .collect(Collectors.toList());

        Collections.sort(list);
        if (list.size()%2 ==0){
            int value1 = list.get(list.size()/2);
            int value2 = list.get((list.size()/2)-1);
            return ((float)(value1+value2)/2);
        }
        return numbers[numbers.length/2];
    }
    public static float mean(int[] numbers){
        int sum =0;
        for(int number: numbers)
            sum += number;

        return (float)sum/numbers.length;
    }
    public static int mode(int[] numbers){
        TreeMap<Integer,Integer> tree = new TreeMap<>();
        int count;
        for(int number: numbers) {
            if (tree.containsKey(number)) {
                count = tree.get(number);
                tree.put(number, ++count);
            }
            else
                 tree.put(number, 1);
        }
        int maxValue = 1;
        int maxKey = 0;
        for(Map.Entry<Integer, Integer> entry: tree.entrySet())
            if (entry.getValue() > maxKey) {
                maxValue = entry.getKey();
                maxKey = entry.getValue();
            }

        return maxValue;

    }

}
