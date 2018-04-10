/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

import java.util.Arrays;

public class HeapSort {

    public static void main(String []args){
        int []arr = {4,6,8,5,9,3,1,2,0,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从最后一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    //---------------------------------
    public static void adjustHeap2(int arr[],int index,int length){
        int temp = arr[index];
        for(int k=index*2+1;k<length;k=k*2+1){
            if (arr[k]<arr[k+1] && k+1 < length){
                k++;
            }
            if (arr[k]>temp){
                arr[index] = arr[k];
                index = k;
            }else{
                break;
            }
        }
        arr[index] = temp;
    }

    public static void sort2(int arr[]){
        // 构造大顶堆
        for(int i = arr.length/2-1;i>=0;i--){
            adjustHeap2(arr,i,arr.length);
        }

        // 交换并重新调整
        for(int i = arr.length-1;i>0;i--){
            swap(arr,0,i);
            adjustHeap2(arr,0,i);
        }
    }
}
