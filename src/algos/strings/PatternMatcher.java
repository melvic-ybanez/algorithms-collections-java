package algos.strings;

/**
 * Created by ybamelcash on 3/5/2015.
 */
public class PatternMatcher {
    public static int find(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j = 0;
            while ((j < pattern.length()) && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i;
            }
        }
        return -1;
    }
}
