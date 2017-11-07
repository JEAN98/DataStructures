/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 *
 * @author kenma
 */
public class ListOfTree {

    private Tree selectedTree;
    private Tree root;

    public ListOfTree() {
        this.selectedTree = null;
    }

    /**
     * Add tree.
     *
     * @param tree
     */
    public void addTree(Tree tree) {

        if (root == null) {

            root = tree;
            root.setNext(root);
            root.setBack(root);

        } else {

            Tree aux = root;

            while (aux.getNext() != root) {

                aux = aux.getNext();
            }

            aux.setNext(tree);
            tree.setBack(aux);
            tree.setNext(root);
            root.setBack(tree);

        }
    }

    /**
     * Delete tree.
     *
     * @param tree
     */
    public void deleteTree(Tree tree) {

        if (root.getNext() == root) {

            root = null;
        } else if (root == tree) {

            root.getBack().setNext(root.getNext());
            root.getNext().setBack(root.getBack());
            root = root.getNext();
        } else {

            Tree aux = root.getNext();

            while (aux != root) {

                if (aux == tree) {

                    aux.getBack().setNext(aux.getNext());
                    aux.getNext().setBack(aux.getBack());

                    return;
                }

                aux = aux.getNext();
            }
        }
    }

    /**
     * Select tree.
     */
    public void selectTree() {
    }

    /**
     * Retorn all trees of the list.
     *
     * @return
     */
    public ObservableList<Tree> getAllTrees() {

        ObservableList<Tree> treesItems = FXCollections.observableArrayList();

        if (root == null) {

            return treesItems;
        } else {

            treesItems.add(root);

            Tree aux = root.getNext();

            while (aux != root) {

                treesItems.add(aux);

                aux = aux.getNext();
            }
        }

        return treesItems;
    }

    public Tree getSelectedTree() {
        return selectedTree;
    }

    public void setSelectedTree(Tree selectedTree) {
        this.selectedTree = selectedTree;
    }
}
