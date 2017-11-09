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

    private String answer;
    private String answerTree;

    public Leaf(String question, String answerTree, int id, TreeNodeType treeNodeType) {
        super(id, treeNodeType);
        this.answer = question;
        this.answerTree = answerTree;
    }

    public String getAnswerTree() {
        return answerTree;
    }

    public void setAnswerTree(String answer) {
        this.answerTree = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String question) {
        this.answer = question;
    }
}
