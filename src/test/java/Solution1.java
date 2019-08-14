import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution1 implements Solution {
    @Override
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> orig = IntStream.of(nums).boxed().collect(Collectors.toList());
        result.add(orig);

        List<Integer> curr;
        do {
            perm(nums);
            curr = IntStream.of(nums).boxed().collect(Collectors.toList());
//            System.out.println(curr);
            if (!curr.equals(orig)) {
                result.add(curr);
            }
        } while (!curr.equals(orig));

        return result;
    }

    private void perm(int[] nums) {
        int last = lastLocalMax(nums);
        if (last == 0) {
            Arrays.sort(nums);
        } else {
            int idx = last;
            for (int i = last; i < nums.length; i++) {
                if (nums[i] > nums[last-1]) {
                    idx = i;
                }
            }
            swap(nums, last-1, idx);
            Arrays.sort(nums, last, nums.length);
        }
    }

    private int lastLocalMax(int[] nums) {
        int i = nums.length-1;
        while (i > 0 && nums[i] <= nums[i-1]) {
            i--;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
