class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left_pointer = 0;
        int right_pointer = n - 1;

        // Left se longest non-decreasing subarray find karte hain
        while (left_pointer + 1 < n && arr[left_pointer] <= arr[left_pointer + 1]) {
            left_pointer++;
        }
        
        // Agar pura array non-decreasing hai, to kuch remove karne ki zaroorat nahi
        if (left_pointer == n - 1) {
            return 0;
        }
        
        // Right se longest non-decreasing subarray find karte hain
        while (right_pointer > left_pointer && arr[right_pointer] >= arr[right_pointer - 1]) {
            right_pointer--;
        }
        
        // Initial minimum length calculate karte hain jo remove karna padega
        int min_len = Math.min(n - left_pointer - 1, right_pointer);

        // Left aur right parts ko merge karne ki koshish karte hain
        for (int i = 0, j = right_pointer; i <= left_pointer && j < n; ) {
            if (arr[i] <= arr[j]) {
                min_len = Math.min(min_len, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        // Final result return karte hain
        return min_len;
    }

}
public class CODE{
    public static void main(String args[])
    {
        Solution s = new Solution();
         system.out.println("i am aditya ");
    }
}
