/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

/**
 *
 * @author kenma
 */
public class TreeNode {

    private int id;
    private TreeNodeType treeNodeType;

    public TreeNode(int id, TreeNodeType treeNodeType) {
        this.id = id;
        this.treeNodeType = treeNodeType;
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
