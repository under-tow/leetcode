package cn.under2.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Code4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 == 0 && len2 == 0) {
            return 0;
        } else if (len1 == 0) {
            return len2 % 2 == 0 ? (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2d : nums2[len2 / 2];
        } else if (len2 == 0) {
            return len1 % 2 == 0 ? (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2d : nums1[len1 / 2];
        }
        int len;
        List<Integer> nums = new ArrayList<>();
        if (nums1[len1 - 1] < nums2[0]) {
            nums.addAll(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
            nums.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
            len = nums.size();
            return len % 2 == 0 ? (nums.get(len / 2 - 1) + nums.get(len / 2)) / 2d : nums.get(len / 2);
        } else if (nums2[len2 - 1] < nums1[0]) {
            nums.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
            nums.addAll(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
            len = nums.size();
            return len % 2 == 0 ? (nums.get(len / 2 - 1) + nums.get(len / 2)) / 2d : nums.get(len / 2);
        } else {

        }
        return 0d;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m, ansi = -1;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                ansi = i;
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }


    public static void main(String[] args) {
        double res = findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        System.out.println("RESULT==>" + res);
    }
}
