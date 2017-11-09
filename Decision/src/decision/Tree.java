/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

import java.util.ArrayList;
import javafx.scene.control.TreeItem;

/**
 *
 * @author kenma
 */
public class Tree {

    private String question;
    private String description;
    private int id;
    private Tree next;
    private Tree back;
    private TreeNode root;

    public Tree(String question, String description, int id) {
        this.question = question;
        this.description = description;
        this.id = id;
    }

    public void addRootNode(TreeNode treeNode) {

        root = treeNode;
    }

    public int numberOfCombinations() {

        int numberOfCombinations = 0;

        if (root != null) {

            numberOfCombinations += numberOfCombinations(root);
        }

        return numberOfCombinations;
    }

    private int numberOfCombinations(TreeNode root) {

        int numberOfCombinations = 0;

        if ((root.getChildCount() > 0) || (root.getTreeNodeType() != TreeNodeType.Leaf)) {
            for (TreeNode child : root.getChilds()) {

                numberOfCombinations += numberOfCombinations(child);
            }
        } else {

            numberOfCombinations++;
        }

        return numberOfCombinations;
    }

    public float averageOfsteps() {

        float averageOfsteps = 0;
        int Combinations = numberOfCombinations();
        int[] steps;

        if (root != null) {

            if (Combinations > 0) {

                steps = new int[root.getChildCount()];

                int i = 0;
                for (TreeNode child : root.getChilds()) {

                    steps[i] += steps(child);
                    
                    i++;
                }
                
                int j = 0;
                for (int value : steps) {

                    j += value;
                }
                
                averageOfsteps = (float)j/(float)Combinations;
            }
        }

        return averageOfsteps;
    }
    
    private int steps(TreeNode root) {

        int steps = 0;

        if (root.getChildCount() > 0) {
            for (TreeNode child : root.getChilds()) {

                steps += 1 + steps(child);
            }
        } else {
        
            steps++;
        }

        return steps;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tree getNext() {
        return next;
    }

    public void setNext(Tree next) {
        this.next = next;
    }

    public Tree getBack() {
        return back;
    }

    public void setBack(Tree back) {
        this.back = back;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
