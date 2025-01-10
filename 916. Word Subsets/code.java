import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
      
        int[][] matrix = new int[words1.length][26];
        for (int i = 0; i < words1.length; i++) {
            for (int j = 0; j < words1[i].length(); j++) {
                matrix[i][words1[i].charAt(j) - 'a']++;
            }
        }

       
        int[] arr = new int[26];
        for (int i = 0; i < words2.length; i++) {
            String str = words2[i];
            int[] tempArr = new int[26];
            for (int j = 0; j < str.length(); j++) {
                tempArr[str.charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                arr[k] = Math.max(arr[k], tempArr[k]);
            }
        }

      
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words1.length; i++) {
            boolean isSubset = true;
            for (int k = 0; k < 26; k++) {
                if (matrix[i][k] < arr[k]) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) {
                result.add(words1[i]);
            }
        }

        return result;
    }
}
