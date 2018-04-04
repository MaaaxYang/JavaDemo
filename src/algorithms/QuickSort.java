/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

public class QuickSort {

    public static void sort(int[] arr,int low,int high){
        if(low >= high){
            return ;
        }
        int mid = partition(arr,low,high);
        sort(arr,low,mid-1);
        sort(arr,mid+1,high);
    }

    public static int partition(int[] arr,int low,int high){

        int old=arr[low];

        while(low < high){

            while(arr[high]>=old && high>low){
                high--;
            }
            arr[low]=arr[high];

            while(arr[low]<=old && high>low){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[high]=old;
        return high;
    }

}
