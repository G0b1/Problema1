/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Gabi
 */
/*
1. Given a list of n natural numbers ranging between 1 and 1,000,000,000, 
find the most popular k scores in the descending order of their frequency.
Input: n = 11, k = 3, 
numbers = [6, 5, 2, 6, 6, 2, 1, 7, 3, 3, 3]
Output: [6, 3, 2]
 */
public class Problema1 {

    public int maxFrequent(HashMap<Integer, Integer> map) {
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        return max;
    }

    public HashMap<Integer, Integer> countFrequencyForEachElem(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    public List<Integer> printResult(int max, ArrayList<Integer>[] arr, int k) {
        List<Integer> result = new ArrayList<Integer>();
        for (int j = max; j >= 1; j--) {
            if (arr[j].size() > 0) {
                for (int a : arr[j]) {
                    result.add(a);
                    if (result.size() == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public void topKFrequent(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = countFrequencyForEachElem(nums);
        //get the max frequency
        int max = maxFrequent(map);

        //initialize an array of ArrayList
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max + 1];
        for (int i = 1; i <= max; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        //index is frequency, value is list of numbers
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int number = entry.getKey();
            arr[count].add(number);
        }

        //add most frequent numbers to result
        System.out.println("Output: " + printResult(max, arr, k));

    }

    public static void main(String[] args) {
        int[] numbers = null;
        //{6, 5, 2, 6, 6, 2, 1, 7, 3, 3, 3, 8, 9, 9};

        Scanner s = new Scanner(System.in);
        System.out.print("n = ");
        int n = s.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("numbers[" + i + "]= ");
            numbers[i] = s.nextInt();
        }
        System.out.print("k = ");
        int k = s.nextInt();

        Problema1 p = new Problema1();
        p.topKFrequent(numbers, k);
    }

}
