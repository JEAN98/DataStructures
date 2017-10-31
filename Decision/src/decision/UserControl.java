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
public class UserControl {

    private User root;

    public UserControl() {

        this.root = null;
    }

    /**
     * Add new user to users list.
     *
     * @param newUser
     */
    public void insertUser(User newUser) {
        if (root == null) {
            newUser.setPrevious(newUser);
            root = newUser;
        } else {
            User aux = root;
            while (aux.getNext() != root) {
                aux = aux.getNext();
            }
            aux.setNext(newUser);
            newUser.setPrevious(aux);
            newUser.setNext(root);
            root.setPrevious(newUser);
        }
    }
    /**
     * Update information of user
     * @param id
     * @param currentUser 
     */
     public void updateInformation(String id,User currentUser)
    { 
        if (root != null) {
            User aux = root;
            while (aux.getNext() != root && aux.getDni() != id) {
                aux = aux.getNext();
            }
            if (aux.getDni() == id) {
                aux = currentUser;
            }
        }
    }

    /**
     * Delete a user of users list.
     *
     * @param userAtDelete
     */
    public void deleteUser(User userAtDelete) {

    }

    /**
     * 
     * @param id
     * @param password
     * @return 
     */
     public Boolean verifyCredentials(String id,String password){
       if(root != null){
           User temp = root;
           while(temp.getNext() != root && temp.getDni() != id){
               temp = temp.getNext();
           }
           if(temp.getDni()== id && temp.getPassword() == password){
               return true;
           }
       }
       return false;
   }

    /**
     * Closes the current session.
     */
    public void closeSession() {

    }
  }
