/*
 * -1 : o1 < o2
 * 0 : o1 == o2
 * +1 : o1 > o2
 *
 */

/*
 * if found duplicate then sort them do not ignore them, therefore return 1
 * if we were to return 0 then it would have meant that we wish to ignore duplicatas element and only want unique element. 
 *
 */

class Solution {
    public static void main(String[] args) {
        TreeSet<Integer> arr = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2))  
                    return 1;
                return o1.compareTo(o2);
            }
        });
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(5);
        arr.add(4);
        arr.add(0);

        for (var i : arr) {
            System.out.println(i + " ");
        }
    }
}
