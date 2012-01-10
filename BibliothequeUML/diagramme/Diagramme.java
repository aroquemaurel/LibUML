package diagramme;

import eltGraphique.ElementGraphique;
import eltGraphique.Liste;

/**
 *
 * @author satenske
 */
public class Diagramme {
     /**
     * liste des éléments graphiques
     */
    private Liste<ElementGraphique> eltGraphique;
    public boolean lienAutorise (ElementGraphique p_origine , ElementGraphique p_extremite, String p_typeDeFleche){
        return true;
    }
    public boolean eltAutorise (ElementGraphique p_element){
        return true;
    }
}
