/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

/**
 *
 * @author JeanCarlo
 */
public class Tester {
    
    public Tester(){
    }
    
    public void test(UserControl userControl){
    
        User newUser = new User("Kenet Mauricio Acuña Lago", "1", (short) 0, Sex.Male, "1");
        ListOfTree listOfTree = new ListOfTree();
        Tree tree1 = new Tree("I can play football?", "It helps to decide between going out to play football or not.", 0);
        Tree tree2 = new Tree("I have cancer?", "Dictate a predictive diagnosis.", 1);
        listOfTree.addTree(tree1);
        listOfTree.addTree(tree2);
        newUser.addLListOfTree(listOfTree);
        
        userControl.addUser(newUser);
    }
    
}