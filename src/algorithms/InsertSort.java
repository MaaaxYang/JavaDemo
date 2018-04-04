/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

public class InsertSort {

    public static int[] sort(int arr[]){

        int preIndex = 0;
        int current = 0;

        for (int i = 1; i < arr.length; i++) {

            preIndex = i - 1;
            current = arr[i];

            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }

            arr[preIndex + 1] = current;
        }
        return arr;
    }
}
