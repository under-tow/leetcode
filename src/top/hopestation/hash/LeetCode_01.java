package top.hopestation.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class LeetCode_01 {
    //暴力循环法
    public static int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > target) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。
     * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，
     * 然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];

    }

    public static void main(String[] args) {
        int[] param = {1, 2, 5, 3, 4, 7,};

        String mySoluTest = Arrays.toString(mySoluTest(param, 10));
        System.out.println("mySoluTest = " + mySoluTest);

        String twoSum2 = Arrays.toString(twoSum2(param, 10));
        System.out.println("twoSum2 = " + twoSum2);
    }


    /**
     * 使用一次编辑即可获得结果
     * 遍历数据{
     *     判断是否（target - 当前num） 是否存在hash表中
     *          存在==》返回结果
     *          不存在==》将num和下标 放入 hash表中
     * }
     * @param nums
     * @param target
     * @return
     */
    public static int[] mySoluTest(int[] nums,int target){

        HashMap<Integer,Integer> hashTable = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            if(hashTable.containsKey(target - nums[i])){
               return new int[]{i,hashTable.get(target-nums[i])};
            }
            hashTable.put(nums[i],i);
        }


        return null;
    }
}

