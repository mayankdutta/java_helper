
## Factorial kind of thing. 

```java

import java.math.BigInteger;

class Solution {
    public int numTrees(int n) {
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("1");
        for (int i = n + 2; i <= 2 * n; i++) 
            one = one.multiply(BigInteger.valueOf(i));
       
        for (int i = 1; i <= n; i++) 
            two = two.multiply(BigInteger.valueOf(i));
        
        one = one.divide(two);
        return one.intValue();        
    }
}
```

## Multiplying two big no.s 

```java
import java.math.BigInteger;

class Solution {
    public String multiply(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        
        return a.multiply(b).toString();
    }
}
```
