
class Solution {
    public int minSteps(String s, String t) {
        // Frequency arrays for both strings
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        // Count character frequencies for both strings
        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freqT[c - 'a']++;
        }

        // Calculate the total number of steps required
        int steps = 0;
        for (int i = 0; i < 26; i++) {
            steps += Math.abs(freqS[i] - freqT[i]);
        }

        return steps;
    }

}
