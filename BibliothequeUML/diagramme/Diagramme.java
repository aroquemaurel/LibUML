package diagramme;

import eltGraphique.EltGraphique;
import java.util.List;

/**
 *
 * @author satenske
 */
public class Diagramme {
     /**
     * liste des éléments graphiques
     */
    private List<EltGraphique> eltGraphique;
    public boolean lienAutorise (EltGraphique p_origine , EltGraphique p_extremite, String p_typeDeFleche){
        return true;
    }
    public boolean eltAutorise (EltGraphique p_element){
        return true;
    }
}
