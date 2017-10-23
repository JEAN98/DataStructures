
package code;

import java.util.List;


public class Nodo {
  private int id;
  private String description;
  private List<Nodo> nodoList;

    public Nodo(int id,String description) {
        this.id = id;
        this.description = description;
        this.nodoList = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Nodo> getNodoList() {
        return nodoList;
    }

    public void setNodoList(List<Nodo> nodoList) {
        this.nodoList = nodoList;
    }
  
}
