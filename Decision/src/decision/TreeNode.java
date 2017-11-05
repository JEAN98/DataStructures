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

    private int id;
    private TreeNodeType treeNodeType;
    private ArrayList<TreeNode> treeNodeList;

    
    public TreeNode(int id, TreeNodeType treeNodeType) {
        this.id = id;
        this.treeNodeType = treeNodeType;
        this.treeNodeList = null;
    }    
    
    public ArrayList<TreeNode> getTreeNodeList() {
        return treeNodeList;
    }

    public void setTreeNodeList(ArrayList<TreeNode> treeNodeList) {
        this.treeNodeList = treeNodeList;
    }
    /***
     * Add new Nodo in the tree node list
     * @param newTreeNode 
     */
    public void addTreeNodeInList(TreeNode newTreeNode){
        this.treeNodeList.add(newTreeNode);
    }

    public TreeNodeType getTreeNodeType() {
        return treeNodeType;
    }

    public void setTreeNodeType(TreeNodeType treeNodeType) {
        this.treeNodeType = treeNodeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
