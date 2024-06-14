package sorting;

import java.util.ArrayList;
import java.util.List;

public class SortHeterogeneous {

    public static void main(String[] args) {
        List<Object> input = new ArrayList<>();
        input.add(2);
        input.add(4);
        input.add(1);
        input.add(9);
        input.add("a");
        input.add("n");
        input.add("b");
        input.add("A");
        input.add(9.0);

        List<Object> sorted = sortHeterogeneous(input);
        System.out.println(sorted);
    }

    public static List<Object> sortHeterogeneous(List<Object> nums) {
        List<Integer> integers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        for (Object num : nums) {
            if (num instanceof Integer) {
                integers.add((Integer) num);
            } else if (num instanceof Double) {
                doubles.add((Double) num);
            } else if (num instanceof String) {
                strings.add((String) num);
            } else {
                throw new IllegalArgumentException("Unsupported data type in the list");
            }
        }

        if (!integers.isEmpty()) {
            mergeSort(integers, 0, integers.size() - 1);
        }
        if (!doubles.isEmpty()) {
            mergeSort(doubles, 0, doubles.size() - 1);
        }
        if (!strings.isEmpty()) {
            mergeSort(strings, 0, strings.size() - 1);
        }

        List<Object> sortedNums = new ArrayList<>();
        sortedNums.addAll(integers);
        sortedNums.addAll(doubles);
        sortedNums.addAll(strings);
        return sortedNums;
    }

    private static <T extends Comparable<T>> void mergeSort(List<T> nums, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(nums, left, middle);
            mergeSort(nums, middle + 1, right);

            merge(nums, left, middle, right);
        }
    }

    private static <T extends Comparable<T>> void merge(List<T> nums, int left, int middle, int right) {
        List<T> leftList = new ArrayList<>(nums.subList(left, middle + 1));
        List<T> rightList = new ArrayList<>(nums.subList(middle + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                nums.set(k, leftList.get(i));
                i++;
            } else {
                nums.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < leftList.size()) {
            nums.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < rightList.size()) {
            nums.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
}
