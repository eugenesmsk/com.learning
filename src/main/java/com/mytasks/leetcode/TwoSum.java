//https://leetcode.com/problems/two-sum/submissions/

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            
            int currentKey = target - nums[i];
            if(map.containsKey(currentKey)) {
                return new int[]{i, map.get(currentKey)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Trouble");
    }
}
