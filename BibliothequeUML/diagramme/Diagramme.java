package diagramme;

import eltGraphique.EltGraphique;
import eltGraphique.ligne.TypeLien;
import java.util.List;

/**
 * Classe ancêtre de trois diagrammes: 
 * Classe, CasUtilisation et Séquence
 * Ces trois types de diagrammes sont différenciés 
 * par les éléments qui les constituent
 * 
 * @author satenske
 * @author Marie-Ly
 */
public class Diagramme {
     /**
     * liste des éléments graphiques
     */
    private List<EltGraphique> eltGraphique;
    /**
     * vérifie si le lien est autorisé
     * @return true s'il est autorisé
     */
    public boolean lienAutorise (EltGraphique p_origine , EltGraphique p_extremite, TypeLien p_typeDeFleche){
        return true;
    }
    /**
     * vérifie si l'élément est autorisé
     * @return true s'il est autorisé
     */
    public boolean eltAutorise (EltGraphique p_element){
        return true;
    }
}
