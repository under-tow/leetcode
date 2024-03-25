package top.hopestation.tree;


import top.hopestation.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  94. 二叉树的中序遍历
 *  给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 */
public class Code94 {

    public static void main(String[] args) {
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

        List<Integer> midList = new ArrayList<>();
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();

        mediumOrderTraversal(root,midList);
        preOrderTraversal(root,preList);
        postOrderTraversal(root,postList);

        System.out.println("中序 = " + Arrays.toString(midList.toArray()));
        System.out.println("先序 = " + Arrays.toString(preList.toArray()));
        System.out.println("后序 = " + Arrays.toString(postList.toArray()));


    }

    /**
     * 中序遍历
     * @param node
     * @param list
     */
    private static void mediumOrderTraversal(TreeNode node, List<Integer> list ){
        if(node==null){
            return;
        }
        mediumOrderTraversal(node.left,list);
        list.add(node.val);
        mediumOrderTraversal(node.right,list);
    }

    /**
     * 先序遍历
     * @param node
     * @param list
     */
    private static void preOrderTraversal(TreeNode node, List<Integer> list ){
        if(node==null){
            return;
        }
        list.add(node.val);
        preOrderTraversal(node.left,list);
        preOrderTraversal(node.right,list);
    }


    /**
     * 后序遍历
     * @param node
     * @param list
     */
    private static void postOrderTraversal(TreeNode node, List<Integer> list ){
        if(node==null){
            return;
        }
        postOrderTraversal(node.left,list);
        postOrderTraversal(node.right,list);
        list.add(node.val);
    }


}


