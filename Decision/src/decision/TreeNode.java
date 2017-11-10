/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

import java.util.ArrayList;

/**
 *
 * @author kenma
 */
public class TreeNode {

    private TreeNodeType treeNodeType;
    private TreeNode[] childs;
    private int childCount;

    public TreeNode( TreeNodeType treeNodeType) {
        this.treeNodeType = treeNodeType;
        this.childCount = 0;
        this.childs = new TreeNode[0];
    }

    /**
     * *
     * Add new Nodo in the tree node list
     *
     * @param child
     */
    public void addNode(TreeNode child) {

        if (child != null) {

            int i = 0;

            while (childs[i] != null || childs.length < i) {

                i++;
            }

            childs[i] = child;

        }
    }

    public TreeNodeType getTreeNodeType() {
        return treeNodeType;
    }

    public void setTreeNodeType(TreeNodeType treeNodeType) {
        this.treeNodeType = treeNodeType;
    }

    public void getShorRoutebyLeafYes() {

    }

    public TreeNode[] getChilds() {
        return childs;
    }

    public void setChilds(TreeNode[] childs) {
        this.childs = childs;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
        this.childs = new TreeNode[this.childCount];
    }

}
