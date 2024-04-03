package cn.under2.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 */
public class Code118 {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(15);
        for (List<Integer> list : generate) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }


    /**
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                rows.add(List.of(1));
                continue;
            }
            List<Integer> row = new ArrayList<>(i);
            List<Integer> rowBefore = rows.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(rowBefore.get(j - 1) + rowBefore.get(j));
                }
            }
            rows.add(row);
        }
        return rows;
    }


}
