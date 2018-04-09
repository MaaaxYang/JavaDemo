/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

public class BinarySearch {

    public static int search(int[] arr,int key){

        int lowIndex = 0;
        int highIndex = arr.length-1;

        while (lowIndex<=highIndex){

            int mid = lowIndex + (highIndex-lowIndex)>>1;

            if (key<arr[mid]){
                highIndex = mid-1;
            }else if(key>arr[mid]){
                lowIndex = mid +1;
            }else {
                return mid;
            }

        }
        return -1;
    }
}
