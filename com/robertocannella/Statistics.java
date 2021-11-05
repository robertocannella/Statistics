package com.robertocannella;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {

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
