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

    private User userSession;

    public UserControl() {

        this.userSession = null;
    }

    /**
     * Add new user to users list.
     *
     * @param newUser
     */
    public void addUser(User newUser) {

    }

    /**
     * Delete a user of users list.
     *
     * @param userAtDelete
     */
    public void deleteUser(User userAtDelete) {

    }

    /**
     * Init session whit the dni and password.
     *
     * @param dni
     * @param password
     */
    public void login(String dni, String password) {

    }

    /**
     * Closes the current session.
     */
    public void closeSession() {

    }

    public User getUserSession() {
        return userSession;
    }

    public void setUserSession(User userSession) {
        this.userSession = userSession;
    }

}
