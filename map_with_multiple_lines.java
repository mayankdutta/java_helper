import java.util.*;

class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();

    while (n-- >= 0) {

      Map<String, Integer> mp = new TreeMap<>();
      String s = "";
      try {
        s = in.nextLine();
      } catch (Exception e) {
        System.exit(0);
      }
      String[] arr = s.split(" ");

      for (var i : arr) {
        try {
          mp.put(i, mp.get(i) + 1);
        } catch (Exception e) {
          mp.put(i, 1);
        }

      }
      for (var i : arr) {
        if (mp.get(i) > 0) {
          System.out.print(i + " ");
          mp.replace(i, 0);
        }
      }
      System.out.println();
    }
  }
}
