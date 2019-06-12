package com.dodoi.algorithms.dynamicProgramming;

/**
 * 动态规划--矩阵最小的路径和
 */
public class MiniPathMatrix {

    /**
     * 方法一，时间复杂度O(M*N)，空间复杂度O(M*N)
     * @param array
     * @return
     */
    public static int getMiniPathBaseMatrix(int[][] array){
        if( array == null || array.length == 0 || array[0] == null || array[0].length == 0 ) {
            return 0;
        }
        int row = array.length;
        int col = array[0].length;

        // 存储每个位置[i][j]的最小路径矩阵
        int[][] miniPathMatrix = new int[row][col];

        miniPathMatrix[0][0] = array[0][0];
        //最小路径矩阵[i][0]的最小路径,第一列的数据
        for(int i = 1; i<row;i++){
            miniPathMatrix[i][0] = miniPathMatrix[i-1][0] + array[i][0];
        }

        //最小路径矩阵[0][j]的最小路径，第一行的数据
        for(int j = 1; j<col;j++){
            miniPathMatrix[0][j] = miniPathMatrix[0][j-1] + array[0][j];
        }

        //计算其他位置的最小路径
        for(int i = 1; i<row;i++){
            for(int j = 1; j<col;j++){
                miniPathMatrix[i][j] = Math.min(miniPathMatrix[i-1][j],miniPathMatrix[i][j-1]) + array[i][j];
            }
        }

        System.out.println("原始数据：");
        printFormatArray(array);
        System.out.println("最小路径矩阵：");
        printFormatArray(miniPathMatrix);

        return miniPathMatrix[row-1][col-1];
    }

    public static int getMiniPathBaseArray(int[][] array){
        if( array == null || array.length == 0 || array[0] == null || array[0].length == 0 ) {
            return 0;
        }

        int col = array[0].length;
        int[] minPath = new int[col];

        minPath[0] = array[0][0];

        //最小路径矩阵[0][j]的最小路径，第一行的数据
        for(int i = 1; i<col;i++){
            minPath[i] = minPath[i-1] + array[0][i];
        }

        int row = array.length;
        for( int i = 1; i < row; i++ ){
            minPath[0] = minPath[0] + array[i][0];
            for( int j = 1; j < col; j++ ){
                minPath[j] = Math.min(minPath[j-1],minPath[j]) + array[i][j];
            }
        }

        return minPath[col-1];
    }

    public static void main(String[] args){
        // 给定一个M*N(5*4)的矩阵,从左上角开始，每步只能向下或向右走，
        int[][] array = {
                {1,4,8,5},
                {5,4,1,3},
                {4,9,6,8},
                {3,5,1,0},
                {5,3,5,3}};
        System.out.println("BaseMatrix 最短路径："+getMiniPathBaseMatrix(array));
        System.out.println("BaseArray 最短路径："+getMiniPathBaseArray(array));
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
