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
    private boolean answerTree;

    public Leaf(String answer, boolean answerTree) {
        super( TreeNodeType.Leaf);
        this.answer = answer;
        this.answerTree = answerTree;
    }

    public boolean getAnswerTree() {
        return answerTree;
    }

    public void setAnswerTree(boolean answer) {
        this.answerTree = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String question) {
        this.answer = question;
    }
}
