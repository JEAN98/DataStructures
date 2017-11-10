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
    
    public void test(UserControl userControl, GeneratorID generatorID){
        
        //User 1
    
        User newUser = new User("Kenet Mauricio Acuña Lago", "1", (short) 0, Sex.Male, "1");
        
        ListOfTree listOfTree = new ListOfTree();
        Tree tree1 = new Tree("I can play golf?", "It helps to decide between going out to play golf or not.", generatorID.getIdTree());
      
        Root root = new Root("How is the outlook?");
        root.setChildCount(3);
        
        Desission d = new Desission("Is it windy?", "Is it sunny.");
            Leaf l2 = new Leaf("Yes. It is windy.", false);
            Leaf l3 = new Leaf("No. It is not windy.", true);
            d.setChildCount(2);
            d.addNode(l3);
            d.addNode(l2);
            
        Desission d2 = new Desission("How much humidity is there?", "It's rainy.");
        Leaf l4 = new Leaf("The level is high.", false);
        Leaf l5 = new Leaf("The level is normal.", true);
        d2.setChildCount(2);
        d2.addNode(l5);
        d2.addNode(l4);
        
        
        Leaf l = new Leaf("Is it overcast.", true);
        
        root.addNode(d);
        root.addNode(d2);
        root.addNode(l);

        tree1.setRoot(root);
        
        // end user 1
        
        Tree tree2 = new Tree("I have cancer?", "Dictate a predictive diagnosis.", generatorID.getIdTree());
        listOfTree.addTree(tree1);
        listOfTree.addTree(tree2);
        newUser.addLListOfTree(listOfTree);
        
        User newUser2 = new User("Jean Carlo", "2", (short) 0, Sex.Male, "2");
        Tree tree21 = new Tree("can I ride the bus?", "Very if you can travel with bus", generatorID.getIdTree());
        Tree tree22 = new Tree("can I food in my house?", "diagnosis.", generatorID.getIdTree());
        ListOfTree list2 = new ListOfTree();
        list2.addTree(tree21);
        list2.addTree(tree22);
        newUser2.addLListOfTree(list2);
        
        userControl.addUser(newUser);
        userControl.addUser(newUser2);
    }
    
}
