[Hackerrank Problem](https://www.hackerrank.com/challenges/java-end-of-file/problem)
```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int index = 1; 
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.printf("%d %s\n", index++, s);
        }
    }
}
```
