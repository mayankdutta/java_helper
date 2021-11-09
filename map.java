import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Main {
  public static int migratoryBirds(List<Integer> arr) {
    Map<Integer, Integer> mp = new HashMap<>();
    for (Integer i : arr) {
      if (mp.containsKey(i)) {
        mp.put(i, mp.get(i) + 1);
      } else {
        mp.put(i, 1);

      }
    }

    Integer mx = Integer.MIN_VALUE;
    Integer ans = 0;

    for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
      int one = entry.getKey();
      int two = entry.getValue();
      System.out.printf("key: %d, value: %d\n", one, two);

      if (mx < two) {
        mx = two;
        ans = one;
      }
      if (mx == two) {
        ans = Math.min(ans, one);
      }
    }

    System.out.printf("\nMethod 2\n\n");
    mp.forEach((key, value) -> System.out.printf("key: %d, value: %d\n", key, value));

    return ans;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    Integer n = in.nextInt();
    List<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int num = in.nextInt();
      System.out.printf("i-th is %d\n", i);
      arr.add(num);
    }

    for (Integer i : arr) {
      System.out.printf("%d ", i);
    }

    int ans = migratoryBirds(arr);
    System.out.printf("%d\n", ans);
    in.close();
  }

}

/*
 * 
 * 
 * HashMap<String, HashMap> selects = new HashMap<String, HashMap>();
 * 
 * for(Map.Entry<String, HashMap> entry : selects.entrySet()) { String key =
 * entry.getKey(); HashMap value = entry.getValue();
 * 
 * // do what you have to do here // In your case, another loop. }
 */
