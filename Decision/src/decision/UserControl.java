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
    private User session;

    public UserControl() {

        this.root = null;
    }

    /**
     * Add new user to users list.
     *
     * @param newUser
     */
    public void addUser(User newUser) {

        if (root == null) {

            root = newUser;
        } else {

            User aux = root;

            while (aux.getNext() != null) {

                aux = aux.getNext();
            }

            aux.setNext(newUser);
            newUser.setPrevious(aux);
        }
    }

    /**
     * Update information of user
     *
     * @param id
     * @param currentUser
     */
    public void updateInformation(String id, User currentUser) {
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
     * @param dni
     * @param password
     * @return
     */
    public Boolean login(String dni, String password) {

        if (root != null) {

            User temp = root;

            while (temp != null) {

                if (temp.getDni().equals(dni) && temp.getPassword().equals(password)) {

                    this.session = temp;
                    return true;
                }

                temp = temp.getNext();
            }
        }
        return false;
    }

    /**
     * Closes the current session.
     */
    public void closeSession() {

    }

    public User getRoot() {
        return root;
    }

    public void setRoot(User root) {
        this.root = root;
    }

    public User getSession() {
        return session;
    }

    public void setSession(User session) {
        this.session = session;
    }

}
