/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

/**
 *
 * @author kenet
 */
public class GeneratorID {
    
    private int idTree;

    public GeneratorID() {
        this.idTree = 0;
    }

    public int getIdTree() {
        return idTree += 1;
    }
    
    
}
