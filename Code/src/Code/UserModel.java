
package Code;


public class UserModel {
 private String name;
 private String id;
 private int age;
 private String gender;
 private String password;
 private UserModel next;
 private UserModel before;
 private NodoModel tree;

    public UserModel(String name,String id,int age, String gender, String password) {
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

    public UserModel getNext() {
        return next;
    }

    public void setNext(UserModel next) {
        this.next = next;
    }

    public UserModel getBefore() {
        return before;
    }

    public void setBefore(UserModel before) {
        this.before = before;
    }

    public NodoModel getTree() {
        return tree;
    }

    public void setTree(NodoModel tree) {
        this.tree = tree;
    }
 

}
