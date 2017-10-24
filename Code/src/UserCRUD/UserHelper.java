
package UserCRUD;

import code.UserModel;

/**
 *
 * @author JeanCarlo
 */
public class UserHelper {
   private UserModel root;
   
   public UserHelper(){
       this.root = null;
   }
   /*****
    * In this method we can create user in the root, each nodo has a nodo before and nodo next
    * Also the root has connection with the end nodo,due to we have circular list
    * @param name this attribute save the name of user 
    * @param id this attribute save the userID
    * @param age Age of user 
    * @param gender Gender of user
    * @param password Password of user
    */
   public void create(String name,String id,int age, String gender, String password){
       UserModel newUser = new UserModel(name, id, age, gender, password);
       if(root == null){
           newUser.setNext(newUser);
           newUser.setBefore(newUser);
           root = newUser;          
       }
       else{
           UserModel aux = root;
           while(aux.getNext() != root){
               aux = aux.getNext();
           }
           aux.setNext(newUser);
           newUser.setBefore(aux);
           newUser.setNext(root);
           root.setBefore(newUser);
       }
   }
   public String printUserbyID(String id){
      String result = ""; 
       if(root!= null){
          UserModel aux = root;
          if(aux.getId() == id){
              result += "Name: "+aux.getName() + "\n";
              result += "ID: "+ aux.getId() + "\n";
              result += "Age: "+ aux.getAge() + "\n";
              result += "Gender: "+ aux.getGender() + "\n";
          }
          aux = aux.getNext();
          while(aux != root && aux.getId() != id){
              aux = aux.getNext();
          }
          if(aux.getId() == id){
              result += "Name: "+aux.getName() + "\n";
              result += "ID: "+ aux.getId() + "\n";
              result += "Age: "+ aux.getAge() + "\n";
              result += "Gender: "+ aux.getGender() + "\n";
          }
       }
      return result;
   }
   public String printAllUsers(){
      String result ="";
       if(root!= null){
         UserModel aux = root;
          while(aux.getNext() != root){
               result += "Name: "+aux.getName() + "\n";
              aux = aux.getNext();
          }
          result += "Name: "+aux.getName() + "\n";
          aux =aux.getNext();
          result += "Name: "+aux.getName() + "\n";
          
          result+="*******************" +"\n";
          while(aux.getBefore() != root){
               result += "Name: "+aux.getName() + "\n";
               aux = aux.getBefore();
          }
          result += "Name: "+aux.getName() + "\n";
          aux =aux.getBefore();
          result += "Name: "+aux.getName() + "\n";
       }
      return result;
   }
}
