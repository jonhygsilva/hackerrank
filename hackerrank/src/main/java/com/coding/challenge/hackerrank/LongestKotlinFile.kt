class LongestKotlinFile {

    /*
        Given a string s, find the length of the longest substring without repeating characters.
        https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */

    /**
     * Function to find the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val seen = mutableMapOf<Char, Int>()
        var left = 0
        var maxLength = 0

        for (right in s.indices) {
            // If the character at 'right' has been seen before and is inside the current window, move 'left'
            if (seen.contains(s[right]) && seen[s[right]]!! >= left) {
                left = seen[s[right]]!! + 1
            }

            // Update the maximum length of the substring
            maxLength = maxOf(maxLength, right - left + 1)

            // Record the current character's index
            seen[s[right]] = right
        }

        return maxLength
    }
}


fun main(args: Array<String>) {
    // Example usage of the function
    val inputString = "abcabcbb"
    val result = LongestKotlinFile().lengthOfLongestSubstring(inputString)

    println("The length of the longest substring without repeating characters is: $result")
}