// problem: https://leetcode.com/problems/word-pattern/
// solution: https://leetcode.com/problems/word-pattern/discuss/73402/8-lines-simple-Java

public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
      return false;

    Map index = new HashMap();
    for (int i = 0; i < words.length; ++i)
      /*
       * a single map used as
       * (string, int)
       * (character, int)
       */
      if (!Objects.equals(index.put(pattern.charAt(i), i), index.put(words[i], i)))
        return false;

    return true;
  }
