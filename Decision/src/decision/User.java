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
public class User {

    private String fullName;
    private String dni;
    private short age;
    private Sex sex;
    private String password;
    private User next;
    private User previous;
    private ListOfTree listOfTree;

    /**
     *
     * @param fullName
     * @param dni
     * @param age
     * @param sex
     * @param password
     */
    public User(String fullName, String dni, short age, Sex sex, String password) {
        this.fullName = fullName;
        this.dni = dni;
        this.age = age;
        this.sex = sex;
        this.password = password;
        this.listOfTree = null;
        this.previous = null;
        this.next = null;
                
    }

    /**
     * Add a list of decissions trees.
     */
    public void addLListOfTree(ListOfTree listOfTree) {
        this.listOfTree = listOfTree;
    }

    /**
     * Delete the list of decissions trees.
     */
    public void deleteListOfTree() {
        
        listOfTree = null;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getNext() {
        return next;
    }

    public void setNext(User next) {
        this.next = next;
    }

    public User getPrevious() {
        return previous;
    }

    public void setPrevious(User previous) {
        this.previous = previous;
    }

    public ListOfTree getListOfTree() {
        return listOfTree;
    }

    public void setListOfTree(ListOfTree listOfTree) {
        this.listOfTree = listOfTree;
    }
    
    
}
