class Solution {
    // Variables to store the maximum length of a palindrome found so far,
    // and the starting and ending indices of that palindrome substring
    int max = 0, start = 0, end = 0;

    /**
     * Helper function to check if a substring from index 'i' to 'j' in string 's' is a palindrome.
     */
    public boolean isPalindrome(String s, int i, int j) {
        // Loop through the substring while comparing characters from both ends
        while (i < j) {
            char ch1 = s.charAt(i); // Character from the start
            char ch2 = s.charAt(j); // Character from the end

            // If characters do not match, it's not a palindrome
            if (ch1 != ch2)
                return false;

            // Move pointers inward
            i++;
            j--;
        }

        // If loop completes without returning false, it's a palindrome
        return true;
    }

    /**
     * Function to find the longest palindromic substring in the given string 's'.
     */
    public String longestPalindrome(String s) {
        int n = s.length(); // Get the length of the string

        // Iterate over all possible starting indices of substrings
        for (int i = 0; i < n; i++) {

            // Iterate over all possible ending indices of substrings
            for (int j = 1; j < n; j++) {

                // Check if the current substring s[i...j] is a palindrome
                if (isPalindrome(s, i, j) == true) {

                    // Check if this palindrome is longer than the previous longest
                    if ((j - i + 1) > max) {
                        max = j - i + 1; // Update max length
                        start = i;       // Update starting index
                        end = j;         // Update ending index
                    }
                }
            }
        }

        // Return the longest palindrome substring using start and end indices
        return s.substring(start, end + 1);
    }
}
