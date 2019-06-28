package com.dodoi.algorithms.heap;

import java.util.Arrays;

/**
 * 测试最小堆
 */
public class ArrayMinHeap {

    private int[] list;
    private int index = -1;

    public ArrayMinHeap(int[] array){
        list = new int[array.length];
        for(int i=0;i<array.length;i++){
            list[i] = array[i];
            if(i>0){
                this.shiftUp(i);
            }
        }
        System.out.print(Arrays.toString(list));
    }

    public void insert(int num){
        System.out.println("in:"+num);
        if(num>=this.getMin()){
            list[0] = num;

            this.shiftDown(0);
        }
        for(int i=0;i<list.length;i++){
            System.out.print("result:"+list[i]+",");
        }
        System.out.println();
    }

    public int getMin(){
        if(list.length<=0){
            return 0;
        }
        return list[0];
    }

    private void remove(){

    }

    private void shiftUp(int lastIndex){
        if(lastIndex < 0) {
            return;
        }
        int parentIndex = getParentIndex(lastIndex);
        if(parentIndex>=0 && list[parentIndex] > list[lastIndex]){
            int parentNumTemp = list[parentIndex];
            list[parentIndex] = list[lastIndex];
            list[lastIndex] = parentNumTemp;
            shiftUp(parentIndex);
        }

    }

    public int[] getList(){
        return list;
    }
    private void shiftDown(int i){
        int leftIndex = this.getLeftIndex(i);
        int rightIndex = this.getRightIndex(i);
        if(leftIndex>list.length-1){
            return;
        }
        int minIndex = leftIndex;
        if(rightIndex>list.length-1){
            return;
        }
        if(list[leftIndex]>list[rightIndex]){
            minIndex = rightIndex;
        }

        if(list[i]>list[minIndex]){
            int parentNumTemp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = parentNumTemp;
            shiftDown(minIndex);
        }

    }

    private int getLeftIndex(int i){
        return 2*i + 1;
    }
    private int getRightIndex(int i){
        return 2*i + 2;
    }
    private int getParentIndex(int i){
        if(i == 0){
            return -1;
        }

        return (int)Math.floor((i-1)/2);
    }


    public static void main(String[] args){
        int[] param = {5,3,8,2,5,8,24,7,8,8,3,7,1,4,9,9,4,2};
        ArrayMinHeap heap = new ArrayMinHeap(Arrays.copyOfRange(param, 0, 5));


        for(int i=0;i<param.length;i++){
            heap.insert(param[i]);
        }

        int[] list = heap.getList();
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]+",");
        }
    }
}
