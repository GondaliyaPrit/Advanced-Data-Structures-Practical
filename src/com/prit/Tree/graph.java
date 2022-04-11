package com.prit.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjlist = getadjlist();
     //   perfromBFS(adjlist);

        perfromDFSusingReciorson(adjlist);
    }

    public static ArrayList getadjlist() {
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        adjlist.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        adjlist.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        adjlist.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(4);
        adjlist.add(list4);

        ArrayList<Integer> list5 = new ArrayList<>();
        adjlist.add(list5);

        return adjlist;
    }

    public static void perfromBFS(ArrayList<ArrayList<Integer>> adjlist) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);

        boolean[] visited = new boolean[adjlist.size()];

        while (!queue.isEmpty()) {
            Integer vertax = queue.remove();
            System.out.print(vertax + " ");
            visited[vertax] = true;

            ArrayList<Integer> Newvertextrechable = adjlist.get(vertax);

            for (Integer newvertax : Newvertextrechable) {
                if (!visited[newvertax])
                    queue.add(newvertax);
            }
        }
    }

    public static void perfromDFSusingReciorson(ArrayList<ArrayList<Integer>> adjlist) {
        boolean[] visited = new boolean[adjlist.size()];
        perfromDFSusingReciorson(adjlist,0,visited);
    }

    public static  void perfromDFSusingReciorson(ArrayList<ArrayList<Integer>> adjlist, Integer start , boolean[] visited)
    {
        System.out.print(start+" ");
        visited[start] = true;

        ArrayList<Integer> list = adjlist.get(start);
        for (int i = list.size()-1; i >=0 ; i--) {
            Integer getlist = list.get(i);
            if(!visited[getlist])
            {
                perfromDFSusingReciorson(adjlist,getlist,visited);
            }
        }
    }

}




