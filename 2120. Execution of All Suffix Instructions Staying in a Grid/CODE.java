class Solution {
    public int[] executeInstructions(int n, int[] pos, String s) {
        int[] ans = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ans[i] = function(n, new int[]{pos[0], pos[1]}, s, i, 0);
        }
        return ans;
    }

    private static int function(int n, int[] pos, String s, int str_index, int count) {
        // Base case: if we reach the end of the string
        if (str_index >= s.length()) {
            return count;
        }


        // Check if the current position is out of bounds
        if (pos[0] < 0 || pos[0] >= n || pos[1] < 0 || pos[1] >= n) {
            return count;
        }

        // Move in the direction specified by s.charAt(str_index)
        if (s.charAt(str_index) == 'R') {
            pos[1]++;
        } else if (s.charAt(str_index) == 'L') {
            pos[1]--;
        } else if (s.charAt(str_index) == 'U') {
            pos[0]--;
        } else if (s.charAt(str_index) == 'D') {
            pos[0]++;
        }

        // Check if after moving, we are out of bounds
        if (pos[0] < 0 || pos[0] >= n || pos[1] < 0 || pos[1] >= n) {
            return count;
        }

        // Recursively call for the next character in the string
        return function(n, pos, s, str_index + 1, count + 1);
    }
}
