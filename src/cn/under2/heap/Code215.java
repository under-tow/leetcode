package cn.under2.heap;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 *  给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 *  
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * Created by HopeStation on 2021/7/20
 */
public class Code215 {

    public static void main(String[] args) {
//        int[] arr = {112,2,34,3,2335,0,345};
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println("findKthLargest_Mine(arr,k) = " + findKthLargest_Mine(arr, k));
        System.out.println("findKthLargest_Office(arr,k) = " + findKthLargest_Office(arr, k));
    }

    /**
     * 我的解
     * 思路：
     *  先排序，然后获取倒数第二个值
     * @return
     */
    public static int findKthLargest_Mine(int[] nums, int k) {
        for (int t = 0; t < nums.length-1; t++) {
            for (int i = 0; i < nums.length-t-1; i++) {
                if(nums[i]>nums[i+1]){
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                }
            }
        }
        //System.out.println("nums = " + Arrays.toString(nums));
        return  nums[nums.length-k];
    }

    /**
     * 最简洁实用的写法，学习了。不要自己造轮子了，还没人家的快
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest_Nice(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }



    /**
     * 官方解：
     *  - 使用推排序，时间效率真高
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest_Office(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public static void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public static void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
