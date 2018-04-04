/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

public class MergeSort {


    public static int[] sort(int[] arr,int low ,int high){

        int mid = (low + high)>>1;
        if (low<high){
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
        return arr;
    }

    public static void merge(int[] arr,int low,int mid,int high){

        int[] temp = new int[high-low+1];
        int tempIndex=0;

        int i= low;
        int j = mid+1;

        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                temp[tempIndex++] = arr[i++];
            }else{
                temp[tempIndex++] = arr[j++];
            }
        }

        while(i<=mid){
            temp[tempIndex++] = arr[i++];
        }

        while(j<=high){
            temp[tempIndex++] = arr[j++];
        }

        for(int offset=0;offset<temp.length;offset++){
            arr[low+offset] = temp[offset];
        }
    }
}
