
package Code;

import java.util.List;


public class NodoModel {
  private int id;
  private String description;
  private List<NodoModel> nodoList;

    public NodoModel(int id,String description) {
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

    public List<NodoModel> getNodoList() {
        return nodoList;
    }

    public void setNodoList(List<NodoModel> nodoList) {
        this.nodoList = nodoList;
    }
  
}
