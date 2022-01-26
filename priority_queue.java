// some hackerrank problem

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class tuple {
    StringBuilder name;
    Double marks;
    Integer id;

    public tuple(StringBuilder name, Double marks, Integer id) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<tuple> pq = new PriorityQueue<>(new Comparator<tuple>() {
            @Override
            public int compare(tuple a, tuple b) {
                if (a.marks.equals(b.marks)) {
                    if (a.name.toString().equals(b.name.toString())) {
                        return a.id.compareTo(b.id);
                    }
                    return a.name.compareTo(b.name);
                }
                return b.marks.compareTo(a.marks);
            }
        });
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder(in.next());
            if (s.toString().equals("ENTER")) {
                pq.add(new tuple(new StringBuilder(in.next()), in.nextDouble(), in.nextInt()));
            } else {
                pq.poll();
            }
        }
        if (pq.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!pq.isEmpty()) {
                System.out.println(pq.poll().name);
            }
        }
    }
}
