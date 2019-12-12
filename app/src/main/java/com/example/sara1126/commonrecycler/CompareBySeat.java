package com.example.sara1126.commonrecycler;

import java.util.ArrayList;
import java.util.BitSet;

public class CompareBySeat implements Comparator {
    public ArrayList <BaseModel>arr;
    public CompareBySeat(ArrayList<BaseModel> arr){
        this.arr = arr;
    }
    public void sort(ArrayList<BaseModel> arr){
        sort(arr, 0, arr.size()-1);
    }
    public void  sort(ArrayList<BaseModel> arr, int left, int right){
        if(left >= right)
            return;
        int i = left + 1;
        int j = right;
        BaseModel pivot = arr.get(left);
        do{
            while(i <= right && arr.get(i).getSeat() < pivot.getSeat()) i++;
            while(arr.get(j).getSeat() > pivot.getSeat()) j--;
            if(i >= j){
                break;
            }
            swap(arr, i, j);
        }while(true);
        swap(arr, left, j);
        sort(arr, left, j-1);
        sort(arr, j+1, right);
    }
    public static void swap(ArrayList<BaseModel> arr, int i, int j){
        BaseModel tmp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j, tmp);
    }


}


