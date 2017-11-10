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
public class Desission extends TreeNode {

    private String question;
    private String answer;

    public Desission(String question, String answer) {
        super(TreeNodeType.Desission);
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswerTree(String answer) {
        this.answer = answer;
    }
}
