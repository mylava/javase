package cn.mylava.test;

import java.util.Arrays;
import java.util.List;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 19/07/2018
 */
public class QuickSort {
    public static int[] array = {4,7,9,1,3,0,2,8};
    public static void main(String[] args) {
        quick(0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public static void quick(int low,int high) {
        if (low>high) {
            return;
        }
        int i = low;
        int j = high;
        int key = array[low];

        while (i<j) {
            while (i < j && array[j] > key) {
                j--;
            }

            while (i < j && array[i] <= key) {
                i++;
            }
            if (i<j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        int mid = array[i];
        array[i] = array[low];
        array[low] = mid;

        quick(low,i-1);
        quick(i+1,high);
    }
}
