```java
import java.util.Map;
import java.util.Scanner;

import java.util.*;  

class Solution {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    Map<Integer, Integer> mp = new TreeMap<Integer, Integer>();
    int n = in.nextInt();
    int ans = 100000;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      // System.out.printf("%d ", x);
      if (mp.containsKey(x)) {
        ans = Math.min(ans, Math.abs(mp.get(x) - i));
      } else {
        mp.put(x, i);
      }

    }
    System.out.printf("%d\n", (ans == 100000 ? -1 : ans));

    in.close();

  }
}
```


/*
 * problem: https://www.hackerrank.com/challenges/minimum-distances/problem?isFullScreen=false
 */
