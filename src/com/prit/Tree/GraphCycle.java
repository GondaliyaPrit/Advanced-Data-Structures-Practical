package com.prit.Tree;

import java.util.ArrayList;

public class GraphCycle {
    public static void main(String[] args) {

        Integer[][] matrix = {{0, 0, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
        };
        System.out.println(isCycle(matrix));
    }


    public static boolean isCycle(Integer[][] matrix) {
        boolean[] vistited = new boolean[matrix.length];
        boolean[] recurisve = new boolean[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            if (isCyclicGraph(matrix, i, vistited, recurisve)) {
                return true;
            }
        }
        return false;
    }


    public static boolean isCyclicGraph(Integer[][] matrix, Integer vertax, boolean[] vistited, boolean[] recurisve) {

        if(recurisve[vertax]){
            return true;
        }

        if(vistited[vertax]){
            return false;
        }
        vistited[vertax] = true;
        recurisve[vertax] = true;


        ArrayList<Integer> list = getlist(matrix, vertax);

        for (Integer listdata : list) {
            if(isCyclicGraph(matrix,listdata,vistited,recurisve))
            {
                return  true;
            }
        }
        recurisve[vertax] = false;
        return false;

    }

    public static ArrayList getlist(Integer[][] matrix, Integer vertax) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][vertax] == 1) {
                list.add(i);
            }
        }
        return list;
    }

}
