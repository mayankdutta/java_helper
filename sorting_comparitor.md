given some data, had to store in class, and then required to sort
[Problem](https://www.hackerrank.com/challenges/java-sort/problem?isFullScreen=true)

### Method 1

```java
import java.util.*;

class info {
    Integer id;
    StringBuilder name;
    Double cgpa;

    public info(Integer a, StringBuilder b, Double c) {
        this.id = a;
        this.name = b;
        this.cgpa = c;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<info> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new info(in.nextInt(), new StringBuilder(in.next()), in.nextDouble()));
        }

        Collections.sort(arr, new Comparator<info>() {
            @Override
            public int compare(info o1, info o2) {
                if (Objects.equals(o1.cgpa, o2.cgpa)) {
                    if (Objects.equals(o1.name, o2.name)) {
                        return (o1.id.compareTo(o2.id));
                    }
                    return o1.name.compareTo(o2.name);
                }
                return o2.cgpa.compareTo(o1.cgpa);
            }
        });

        for (var i : arr) {
            System.out.println(i.name);
        }
        in.close();

    }
}
```

[problem](https://www.hackerrank.com/challenges/java-bigdecimal/problem?isFullScreen=true)
### method 2

```java
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Pair {
    BigDecimal first;
    int second;

    Pair(StringBuilder first, int second) {
        this.first = new BigDecimal(String.valueOf(first));
        this.second = second;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<StringBuilder> ans = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            ans.add(new StringBuilder(in.next()));
        }

        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Pair(ans.get(i), i));
        }

        arr.sort(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.first.compareTo(a.first);
            }
        });
        for (Pair i : arr) {
            System.out.println(ans.get(i.second));
        }
    }
}
```
