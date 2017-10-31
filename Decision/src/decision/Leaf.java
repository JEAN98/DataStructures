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
public class Leaf extends TreeNode {

    private String question;
    private String answerTree;

    public Leaf(String question, String answerTree, int id, TreeNodeType treeNodeType) {
        super(id, treeNodeType);
        this.question = question;
        this.answerTree = answerTree;
    }

    public String getAnswer() {
        return answerTree;
    }

    public void setAnswer(String answer) {
        this.answerTree = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
