package eltGraphique;

import java.util.ArrayList;
import eltGraphique.classe.Methode;
/**
 *
 * @author satenske
 */
public class Interface extends eltGraphique.ElementModelisation {
    private ArrayList<Methode> listeDeMethodes;

    public ArrayList<Methode> getListeDeMethodes() {
        return (this.listeDeMethodes);
    }

    public void setListeDeMethodes(ArrayList<Methode> p_listeDeMethodes) {
        this.listeDeMethodes = p_listeDeMethodes;
    }
}
