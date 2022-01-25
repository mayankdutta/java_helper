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
