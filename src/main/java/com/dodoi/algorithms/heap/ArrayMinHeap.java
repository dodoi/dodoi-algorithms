package com.dodoi.algorithms.heap;

import java.util.Arrays;

/**
 * 测试最小堆
 */
public class ArrayMinHeap {

    private int[] list;

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

    /**
     * 如果插入的元素比第一个元素大，则插入元素替换第一个元素，之后执行shiftDown方法
     * @param num
     */
    public void insert(int num){
        if(num>=this.getMin()){
            list[0] = num;
            this.shiftDown(0);
        }
    }

    public int getMin(){
        if(list.length<=0){
            return 0;
        }
        return list[0];
    }

    /**
     * 如果一个节点比它的父节点大（最大堆）或者小（最小堆），那么需要将它同父节点交换位置。这样是这个节点在数组的位置上升。
     * @param lastIndex
     */
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

    /**
     * 如果一个节点比它的子节点小（最大堆）或者大（最小堆），那么需要将它向下移动。这个操作也称作“堆化（heapify）
     */
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

    public int[] getList(){
        return list;
    }


    /**
     * 获得i节点的左子节点坐标
     * @param i
     * @return
     */
    private int getLeftIndex(int i){
        return 2*i + 1;
    }

    /**
     * 获得i节点的右子节点坐标
     * @param i
     * @return
     */
    private int getRightIndex(int i){
        return 2*i + 2;
    }

    /**
     * 获得i节点的父节点坐标
     * @param i
     * @return
     */
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
            System.out.println("插入新元素："+param[i]);
            System.out.println("插入后堆元素："+Arrays.toString(heap.getList()));
        }

    }
}
