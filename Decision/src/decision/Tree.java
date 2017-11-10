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
    public ArrayList<Route> getShortYes(){
     return getShort(true);
  } 

   public ArrayList<Route> getShortNo(){
    return getShort(false);
  } 
   /**
    * Get Short list
    * @param bus
    * @return 
    */
   private ArrayList<Route> getShort(Boolean bus){
        Route[] listRoutes = auxSearchNodesByStatus(bus);
        ArrayList<Route> result = new ArrayList<>();
       //result.add(listRoutes[0]);
       Route route = listRoutes[0];
       result.add(route);
       for (int i = 1; i < listRoutes.length; i++) {
           if (listRoutes[i] != null) {
               if (listRoutes[i].getListNodes().size() < route.getListNodes().size()) {
                   result.clear();
                   route = listRoutes[i];
                   result.add(listRoutes[i]);
               } else if (listRoutes[i].getListNodes().size() == route.getListNodes().size()) {
                   result.add(listRoutes[i]);
               }
           }
       }
        return result;
    }
   /**
    * Get LARGE
    * @return 
    */
    public ArrayList<Route> getLargeNo() {
        return getLarge(false);
    }

    public ArrayList<Route> getLargeYes() {
        return getLarge(true);
        //result.add(listRoutes[0]);
    }

   private ArrayList<Route> getLarge(Boolean bus){
      Route[] listRoutes = auxSearchNodesByStatus(bus);
      ArrayList<Route> result = new ArrayList<>();
      Route route = listRoutes[0];
      result.add(route);
       for (int i = 1; i < listRoutes.length; i++) {
           if (listRoutes[i] != null) {
               if (listRoutes[i].getListNodes().size() > route.getListNodes().size()) {
                   result.clear();
                   route = listRoutes[i];
                   result.add(listRoutes[i]);
               } else if (listRoutes[i].getListNodes().size() == route.getListNodes().size()) {
                   result.add(listRoutes[i]);
               }
           }

       }
      return result;
   }
  
    /**
     * Search short or large answers in cases of (Yes/No)
     *
     * @param bus
     */
    private Route[] auxSearchNodesByStatus(Boolean bus) {
        if (root != null) {
            Route[] routes = new Route[root.getChildCount()];
            int[] steps = new int[root.getChildCount()];

            int i = 0;
            for (TreeNode child : root.getChilds()) {
                //steps[i] += steps(child);
                routes[i] = SearchNodesByStatus(child, bus);
                if (routes[i] != null) {
                    routes[i].addFirstStep(i); //First step by array added
                    routes[i].addFirstNode(child); // first node added
                 }
                 
                i++;
            }
            System.out.println("*******    *****");
             for (int k = 0; k < routes.length; k++) {
                  if(routes[k]!= null){
                    System.out.println("array: "+routes[k].toString());
                     System.out.println("Numero en el array: "+routes[k].getLarge());
                   
                        for (int step : routes[k].getSteps()) {
                            System.out.println("  " + step +" ");
                        }
                        System.out.println("Nodes"+routes[k].getListNodes().size());
                }
            }
             return routes;
        }
       return null;
    }
            
    private Route SearchNodesByStatus(TreeNode root,Boolean bus) {

        int steps = 0;
        Route miniRoute = new Route();
        TreeNode[] array = root.getChilds(); //Here we can get the array of childs
        if (root.getChildCount() > 0) {
            for (int i=0; i< array.length;i++) {  //for (TreeNode child:root.getChilds())
                if(array[i].getTreeNodeType() == TreeNodeType.Leaf){
                     Leaf x = (Leaf) array[i];
                     if(x.getAnswerTree() == bus){
//                         if(steps == 0){                             
//                             steps++;
//                         }
                         miniRoute.updateLarge(1 + steps);
                         miniRoute.addNode(array[i]);
                         miniRoute.setSteps(i);
                         return miniRoute;
                     }
                     return null;
                }
                else{
                    //steps += 1 + steps(array[i]);
                    miniRoute.setSteps(i); //Add number
                    miniRoute.addNode(array[i]);//Add node
                    
                    Route miniRoute2 = SearchNodesByStatus(array[i],bus); //Recursividad
                    
                    miniRoute.updateLarge(1 + miniRoute2.getLarge());
                    miniRoute.setList(combineListSteps(miniRoute.getSteps(), miniRoute2.getSteps())); //Combine numbers
                    miniRoute.setListNodes(combineListNodes(miniRoute.getListNodes(), miniRoute2.getListNodes())); //combine nodes
                }
            }
        } else {
        
              miniRoute.updateLarge(1);
        }
        return miniRoute;
       // return miniRoute;
    }
     private ArrayList<Integer> combineListSteps(ArrayList<Integer> list1,ArrayList<Integer> list2)
     {
         for (Integer integer : list2) {
             list1.add(integer);
         }
         return list1;
     }
      private ArrayList<TreeNode> combineListNodes(ArrayList<TreeNode> list1,ArrayList<TreeNode> list2)
     {
         for (TreeNode node : list2) {
             list1.add(node);
         }
         return list1;
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
