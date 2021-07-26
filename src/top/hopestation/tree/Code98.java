package top.hopestation.tree;

import top.hopestation.common.Tool;
import top.hopestation.common.TreeNode;

/**
 *  98. 验证二叉搜索树
 *  给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class Code98 {

    public static void main(String[] args) {

        /**
         *         1
         *       2   3
         *     4  5 6
         */
        TreeNode root = new TreeNode(1);
        TreeNode n2= new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;


        /**
         *         1
         *       2   3
         *     4  5 6
         */
        TreeNode root2 = new TreeNode(4);
        TreeNode n20= new TreeNode(2);
        TreeNode n30 = new TreeNode(3);
        TreeNode n40 = new TreeNode(4);
        TreeNode n50 = new TreeNode(5);
        TreeNode n60 = new TreeNode(6);
        root2.left = n20;
        root2.right = n50;
        n20.right = n5;
        n50.left = n30;


        /**
         *         1
         *       2   3
         *     4  5 6
         */
        TreeNode root3 = new TreeNode(2);
        TreeNode n21= new TreeNode(2);
        TreeNode n31 = new TreeNode(2);

        root3.left = n21;
        root3.right = n31;

//        System.out.println("isValidBST(root) = " + isValidBST(root));
//        System.out.println("isValidBST(root2) = " + isValidBST(root2));
        Integer[] arr = new Integer[]{5,4,6,null,null,3,7};
        TreeNode root4 = Tool.arr2Tree(arr);

        System.out.println("isValidBST(root3) = " + validTree_Mine(root4));
        System.out.println("isValidBST(root3) = " + validTree_Office(root4,Long.MIN_VALUE, Long.MAX_VALUE));

    }

    /**
     * 思路一：
     *  算错了，结果只保证看，每一颗树的左节点 <= 当前节点 <= 右节点
     *  没有保证 当前节点的 所有左节点 小于当前节点
     *  没有保证 当前节点的 所有右节点 大于当前节点
     * @param node
     * @return
     */
    private static boolean validTree_Mine(TreeNode node) {
        if(node.left!=null){
            if(node.left.val >= node.val){
                return false;
            }else if(!validTree_Mine(node.left)){
                return false;
            }
        }
        if(node.right!=null){
            if(node.right.val <= node.val){
                return false;
            }else if(!validTree_Mine(node.right)){
                return false;
            }
        }
        return true;
    }

    /**
     * 官方解
     * @param node
     * @return
     */
    private static boolean validTree_Office(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return validTree_Office(node.left, lower, node.val) && validTree_Office(node.right, node.val, upper);
    }

}


