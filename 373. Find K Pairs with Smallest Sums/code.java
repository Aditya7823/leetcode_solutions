import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // Handle edge cases
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min-heap to store pairs along with their sums
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        // Initialize the heap with the first element of nums1 paired with elements of nums2
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[] { nums1[i], nums2[0], 0 }); // Store the pair and the index in nums2
        }

        // Extract k smallest pairs
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] currentPair = minHeap.poll(); // Get the smallest pair
            int first = currentPair[0]; // First number from nums1
            int second = currentPair[1]; // First number from nums2
            int indexInNums2 = currentPair[2]; // Index in nums2

            // Add the current pair to the result
            result.add(List.of(first, second));

            // If there's a next element in nums2, add it to the heap
            if (indexInNums2 + 1 < nums2.length) {
                minHeap.offer(new int[] { first, nums2[indexInNums2 + 1], indexInNums2 + 1 });
            }
        }

        return result; // Return the list of k smallest pairs
    }
}
