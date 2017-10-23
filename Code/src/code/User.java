
package code;


public class User {
 private String name;
 private String id;
 private int age;
 private String gender;
 private String password;
 private User next;
 private User before;
 private Nodo tree;

    public User(String name,String id,int age, String gender, String password) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.before = null;
        this.next = null;
        this.tree = null;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public User getBefore() {
        return before;
    }

    public void setBefore(User before) {
        this.before = before;
    }

    public Nodo getTree() {
        return tree;
    }

    public void setTree(Nodo tree) {
        this.tree = tree;
    }
 

}
