#### array -> list -> sorting with ~comparator~, _lambda_ -> array

```java
 public static int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int value : nums) {
            StringBuilder s = new StringBuilder(Integer.toString(value));
            int num = 0;
            for (int j = 0; j < s.length(); j++)
                num = num * 10 + (mapping[s.charAt(j) - '0']);
            mp.put(value , num);
        }
        List<Integer> arr = new ArrayList<>();
//        mp.forEach((k, v) -> {
//            System.out.println(k + " , " + v);
//        });

        for (int i : nums)
            arr.add(Integer.valueOf(i));

        Collections.sort(arr, (a, b) -> {
            if (a.equals(b)) return 0;
//                System.out.println("Numbers: " + a + " , " +  b);
            return mp.get(a).compareTo(mp.get(b));
        });

        int[] temp = new int[arr.size()];
        int k = 0;
        for (Integer i : arr) {
            temp[k++] = i.intValue();
        }
        return temp;
    }

```
