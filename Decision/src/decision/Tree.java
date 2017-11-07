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
public class Tree {

    private String question;
    private String description;
    private int id;
    private Tree next;
    private Tree back;

    public Tree(String question, String description, int id) {
        this.question = question;
        this.description = description;
        this.id = id;
    }

    public void addNode(TreeNode treeNode) {

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
}
