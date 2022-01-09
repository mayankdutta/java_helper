class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.valueOf(in.readLine());
    HashMap<String, Integer> mp = new HashMap<>();

    while (n-- > 0) {
      String name = in.readLine();
      int phone = Integer.valueOf(in.readLine());
      mp.put(name, phone);
    }

    String s;
    while ((s = in.readLine()) != null) {
      if (mp.containsKey(s))
        System.out.println(s + "=" + mp.get(s));
      else
        System.out.println("Not found");

    }

    in.close();
  }
}
