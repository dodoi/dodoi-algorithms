package com.dodoi.algorithms.dynamicProgramming;

/**
 * 动态规划--矩阵最小的路径和
 */
public class MiniPathMatrix {

    public static int getMiniPath(int[][] array){
        // 存储每个位置[i][j]的最小路径矩阵
        int[][] miniPathMatrix = new int[5][4];

        miniPathMatrix[0][0] = array[0][0];
        //最小路径矩阵[i][0]的最小路径,第一列的数据
        for(int i = 1; i<miniPathMatrix.length;i++){
            miniPathMatrix[i][0] = miniPathMatrix[i-1][0] + array[i][0];
        }

        //最小路径矩阵[0][j]的最小路径，第一行的数据
        for(int j = 1; j<miniPathMatrix[0].length;j++){
            miniPathMatrix[0][j] = miniPathMatrix[0][j-1] + array[0][j];
        }

        for(int i = 1; i<miniPathMatrix.length;i++){
            for(int j = 1; j<miniPathMatrix[0].length;j++){
                int min = miniPathMatrix[i][j-1]>miniPathMatrix[i-1][j]?miniPathMatrix[i-1][j]:miniPathMatrix[i][j-1];
                miniPathMatrix[i][j] = min + array[i][j];
            }
        }


        System.out.println("原始数据：");
        printFormatArray(array);
        System.out.println("最小路径矩阵：");
        printFormatArray(miniPathMatrix);

        return miniPathMatrix[array.length-1][array[0].length-1];

    }

    public static void main(String[] args){
        // 给定一个M*N(5*4)的矩阵,从左上角开始，每步只能向下或向右走，
        int[][] array = {
                {1,4,8,5},
                {5,4,1,3},
                {2,1,5,4},
                {3,5,1,0},
                {5,3,5,3}};
        System.out.println("最短路径："+getMiniPath(array));
    }

    private static void printFormatArray(int array[][]){
        for(int i = 0; i<array.length;i++){
            System.out.print("[");
            for(int j = 0; j<array[0].length;j++){
                if(j != 0 ){
                    System.out.print("，");
                }
                System.out.print(array[i][j]);

            }
            System.out.println("]");
        }
    }
}
