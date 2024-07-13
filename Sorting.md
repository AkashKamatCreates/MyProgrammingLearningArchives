# MergeSort Code

'''
package org.example;

import java.util.*;

public class mergesort {
    public static void main(String[] args){
        int[] arr = {9, 8, 7, 6, 5};
        mergesort(arr, 0, arr.length-1);
        for(int x:arr){
            System.out.print(x+" ");
        }
    }

    public static void merge(int[] arr, int low, int mid, int high){
        List<Integer> ans = new ArrayList<Integer>();
        int left = low;
        int right = mid+1;

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right])ans.add(arr[left++]);
            else ans.add(arr[right++]);
        }

        while(left<=mid) ans.add(arr[left++]);
        while(right<=high) ans.add(arr[right++]);

        for(int i=low; i<=high; i++){
            arr[i] = ans.get(i-low);
        }
    }

    public static void mergesort(int[] arr, int low, int high){
        if(low>=high) return;
        int mid = (low+high)/2;
        mergesort(arr, low, mid);
        mergesort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
}

'''
