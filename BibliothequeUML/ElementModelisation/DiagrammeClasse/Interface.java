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
        return (this.listeDeMethodes);
    }

    public void setListeDeMethodes(ArrayList<Methode> p_listeDeMethodes) {
        this.listeDeMethodes = p_listeDeMethodes;
    }
}
