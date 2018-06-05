package qlm.qlm14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Qlm {

    private static int[][] graph = new int[1000][1000];
    private static List<Integer> unvisited = new ArrayList<Integer>();
    private static List<Integer> visited = new ArrayList<Integer>();

    public static void graphInitialize() {

        try {
            FileReader fr =
                    new FileReader("/Users/chuanshi/Downloads/144047638844506.txt");
            BufferedReader br = new BufferedReader(fr);
            String in = null;
            while ((in = br.readLine()) != null) {
                String[] fragment = in.split(" ");
                int one = Integer.valueOf(fragment[0]) - 1;
                int two = Integer.valueOf(fragment[1]) - 1;
                graph[one][two] = graph[two][one] = 1;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        graphInitialize();

        //put all users into unvisited set
        for (int i = 0; i < 100; i++) {
            unvisited.add(i);
        }

        //the amount of connected components
        int count = 0;
        //DFS all users
        while (!unvisited.isEmpty()) {
            count++;
            dfs(unvisited.get(0));
        }

        System.out.println(count);
    }

    public static void dfs(int s) {
        //put s into the visited set
        visited.add(s);
        unvisited.remove(new Integer(s));
        for (int j = 0; j < 100; j++) {
            if (graph[s][j] == 1 && !visited.contains(j)) {
                dfs(j);
            }
        }
    }
}
