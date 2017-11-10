/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

import java.util.ArrayList;

/**
 *
 * @author jvega-as
 */
public class Route {
    private ArrayList<Integer> steps;
    private ArrayList<TreeNode> listNodes;
    private int large;

    public Route() {
        this.large = 0;
        this.steps = new ArrayList<>();
        this.listNodes = new ArrayList<>();
    }

    public ArrayList<Integer> getSteps() {
        return steps;
    }
    
    public void setList(ArrayList<Integer> list) {
        this.steps = list;
    }

    public ArrayList<TreeNode> getListNodes() {
        return listNodes;
    }
    
    public void addFirstNode(TreeNode node) {
        this.listNodes.add(0, node);
    }

    public void addFirstStep(int number) {
        this.steps.add(0, number);
    }
    
    public void addNode(TreeNode node){
        this.listNodes.add(node);
    }
    public void setListNodes(ArrayList<TreeNode> listNodes) {
        this.listNodes = listNodes;
    }
    public void setSteps(int newStep) {
        this.steps.add(newStep);
    }

    public int getLarge() {
        return large;
    }

    public void updateLarge(int step) {
        this.large += step;
    }
}