package cn.mylava._300._122_Sort;

import java.util.Arrays;

/**
 * 冒泡排序,注意循环终止的条件
 *
 * 思考集合类的排序
 *
 * @author lipengfei
 */
public class BubbleSort1 {
    public static void main(String[] args) {
        int[] arr = {9,1,2,3,4};

        boolean sorted = true;

        for (int i=0;i<arr.length-1;i++) {
            sorted = true;//假定第一轮循环完数组已经完成排序
            for (int j=0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    sorted = false; //有交换说明假定是错误的
                }
            }
            if (sorted){//如果sorted为true，说明排序已经完成，直接跳出循环
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
