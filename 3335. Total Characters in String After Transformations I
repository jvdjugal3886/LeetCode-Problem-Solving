//For solving this problem, we should not actually need to construct the string, because that would be too slow and memory intensive.
//Instead, we can track the length of the string.
//If a character is 'z' it becomes "ab", thus increases by lenght 1.
//If there is any other character, it becomes the next character, but the length remains same.
//I can simulate these transformations using a queue or an array to track the number of characters at each level of transformation, instead of building the actual string 
//For the data type, we can use long[] or Deque<Character> approach, but for efficiency, we can instead simulate the growth using a long[] count of how many characters we are processing.
//So, lets go with long[] counts to store the number of characters in the current string.
class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        long[] count = new long[26]; // count[i] = number of characters 'a' + i

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int step = 0; step < t; step++) {
            long[] next = new long[26];
            for (int i = 0; i < 26; i++) {
                if (i == 25) { // 'z'
                    next[0] = (next[0] + count[25]) % MOD; // 'a'
                    next[1] = (next[1] + count[25]) % MOD; // 'b'
                } else {
                    next[i + 1] = (next[i + 1] + count[i]) % MOD;
                }
            }
            count = next;
        }

        long result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + count[i]) % MOD;
        }

        return (int) result;
    }
}
