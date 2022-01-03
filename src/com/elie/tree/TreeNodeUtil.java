package com.elie.tree;

import com.sun.source.tree.Tree;

public class TreeNodeUtil {
    public static TreeNode createTreeNode(int[] array) {
        TreeNode root = createTreeNode(array, 1);
        return root;
    }

    private static TreeNode createTreeNode(int[] array, int index) {
        if (index > array.length) {
            return null;
        }

        Integer value = array[index - 1];
        if (value == null) {
            return null;
        }

        TreeNode node = new TreeNode(value);
        node.left = createTreeNode(array, index * 2);
        node.right = createTreeNode(array, index * 2 + 1);
        return node;
    }

}
