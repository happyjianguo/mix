package qlm.qlm15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Qlm {

    private static User[] users = new User[100000];
    private static int count = 0;

    /**
     * find certain user's root parent and do path compression
     *
     * @param user
     * @return the root parent of the user
     */
    public static User find(User user) {
        User root = user;
        //in union-find root's parent is itself
        //if root's parent is not himself
        //then find his parent until root's parent is himself
        while (root.getParent() != root) {
            root = root.getParent();
        }

        //do path compression to make the parent of each user in the path to be the root
        User copy = user, temp;
        while (copy != root) {
            temp = copy.getParent();
            copy.setParent(root);
            copy = temp;
        }
        //return the root parent of the user
        return root;
    }

    /**
     * merge two set-tree
     *
     * @param x
     * @param y
     */
    public static void union(User x, User y) {
        User xRoot = find(x);
        User yRoot = find(y);

        if (xRoot.getRank() > yRoot.getRank()) {
            yRoot.setParent(xRoot);
        } else {
            xRoot.setParent(yRoot);
            if (xRoot.getRank() == yRoot.getRank())
                yRoot.rankInc();
        }
    }

    public static void main(String[] args) {
        //initial every user's parent to themselves
        for (int i = 0; i < 100000; i++) {
            users[i] = new User(i);
        }

        try {
            FileReader fr =
                    new FileReader("/Users/chuanshi/Downloads/144341511030664.txt");
            BufferedReader br = new BufferedReader(fr);
            String in = null;
            while ((in = br.readLine()) != null) {
                String[] fragment = in.split(" ");
                int one = Integer.valueOf(fragment[0]) - 1;
                int two = Integer.valueOf(fragment[1]) - 1;
                union(users[one], users[two]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100000; i++) {
            find(users[i]).setStatus(true);
        }

        for (int i = 0; i < 100000; i++) {
            if (users[i].isRoot()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
