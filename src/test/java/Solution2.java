import java.util.*;

public class Solution2 implements Solution {
    @Override
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 1) {
            result.add(Arrays.asList(nums[0]));
        } else {
            int[] copy = Arrays.copyOf(nums, nums.length-1);
            List<List<Integer>> lists = permute(copy);
            for (List<Integer> tmp : lists) {
                for (int i = 0; i <= tmp.size(); i++) {
                    List<Integer> temp = new ArrayList<>(tmp);
                    temp.add(i, nums[nums.length-1]);
                    result.add(temp);
                }
            }
        }
        Collections.sort(result, (o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (o1.get(i) != o2.get(i)) {
                    return o1.get(i)-o2.get(i);
                }
            }
            return 0;
        });

        return result;
    }
}
