/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementModelisation.DiagrammeClasse;

import java.util.ArrayList;

/**
 *
 * @author satenske
 */
public class Interface extends ElementModelisation.ElementModelisation {
    private ArrayList<Methode> listeDeMethodes;

    public ArrayList<Methode> getListeDeMethodes() {
        return listeDeMethodes;
    }

    public void setListeDeMethodes(ArrayList<Methode> listeDeMethodes) {
        this.listeDeMethodes = listeDeMethodes;
    }
}
