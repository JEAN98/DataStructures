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
     * Delete a user of users list.
     *
     * @param userAtDelete
     */
    public void deleteUser(String id) {
        if (root != null) {
            if (root.getDni() == id) {
                if (root.getNext() != null) {
                    root.getNext().setPrevious(null);
                    root = root.getNext();
                }
                root = null;
                System.out.println("Eliminado al principio");
                return;
            } else {
                User temp = root;
                while (temp != null && temp.getDni() != id) {
                    temp = temp.getNext();
                }
                if (temp != null) {
                    if (temp.getNext() == null) {
                        temp.getPrevious().setNext(null);
                        temp.setPrevious(null);
                        System.out.println("Eliminado al final");
                        return;
                    } else {
                        temp.getPrevious().setNext(temp.getNext());
                        temp.getNext().setPrevious(temp.getPrevious());
                        temp.setPrevious(null);
                        temp.setNext(null);
                        temp = null;
                        System.out.println("Eliminado en el medio");
                        return;
                    }
                }
            }
        }
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
