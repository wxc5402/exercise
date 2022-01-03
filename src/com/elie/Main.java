package com.elie;

import com.elie.heapify.Heapify;
import com.elie.strategyPattern.Context;
import com.elie.strategyPattern.OperationAdd;
import com.elie.strategyPattern.OperationMultiply;
import com.elie.strategyPattern.OperationSubstract;
import com.elie.tree.TreeNode;
import com.elie.tree.TreeNodeUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

       Integer[] root = {1,2,3,4,5,6,7,8,9};
       TreeNode rootHead = TreeNodeUtil.createTreeNode(root);
       TreeNodeUtil.prettyPrintTree(rootHead);
    }
}
