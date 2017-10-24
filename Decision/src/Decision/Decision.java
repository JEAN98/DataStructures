
package Decision;

import UserCRUD.UserHelper;


public class Decision {

   
    public static void main(String[] args) {
      UserHelper user = new UserHelper();
      user.create("Jean", "1", 19, "M", "1234");
      user.create("Mary", "2", 20, "F", "123");
      user.create("Lu", "3", 21, "F", "12");
      
      System.out.println(user.printAllUsers());
    }
    
}
