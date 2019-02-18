package Number15;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//超时,算法没问题,时间复杂度太大
/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author liu CMDEGR
 */

public class Solution1OfNum15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        //solution.threeSum(nums);
        System.out.println(solution.threeSum(nums));
    }
}

/**
 * 思路:
 * 第一步:排序
 * 第二步:两个累加
 * 第三步:是否等于第三个的负数形式
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int temp : nums) {
            System.out.print(temp + ",");
        }
        System.out.println("");

        List<List<Integer>> listResult = new LinkedList<>();
        int temp = 0;
        List<Integer> tempNode = new LinkedList<Integer>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                //System.out.println("............");
                temp = nums[i] + nums[j];
                for (int z = j + 1; z < nums.length; z++) {
                    //System.out.println("============");
                    if (temp == (0 - nums[z])) {
                        tempNode = new LinkedList<>();
                        //System.out.println(nums[i]+","+nums[j]+","+nums[z]+",");
                        tempNode.add(nums[i]);
                        tempNode.add(nums[j]);
                        tempNode.add(nums[z]);

                        if (!listResult.contains(tempNode)) {
                            listResult.add(tempNode);
                        }

                    }
                    //break;
                }
            }
        }

        //tempNode.add(3);
        //listResult.add(tempNode);
        return listResult;
    }
}
