package diagramme;

import eltGraphique.ActeurActif;
import eltGraphique.ActeurPassif;
import eltGraphique.EltGraphique;
import eltGraphique.Traitement;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * Classe propre au diagramme de séquence
 * 
 * @author satenske
 * @author Marie-Ly
 */
public class DiagrammeSequence extends Diagramme {
    
     /**
     * vérifie si le lien est autorisé
     * 
     * @param p_origine
     * @param p_extremite
     * @param p_typeDeFleche
     * @return true s'il est autorisé, false sinon
     */
    
    @Override
    public boolean lienAutorise (EltGraphique p_origine , EltGraphique p_extremite, TypeLien p_typeDeFleche){
        boolean valeurRetour = false;
        if (p_typeDeFleche == TypeLien.ASSOCIATION){
            valeurRetour = this.autorisationAssociation(p_origine , p_extremite); 
        }
        else{
            if(p_typeDeFleche == TypeLien.DEPENDANCE){
                valeurRetour = this.autorisationDependance( p_origine , p_extremite);
            }
        }      
        return valeurRetour;
    }
    
     /**
     * méthode qui autorise le lien d'association
     * en fonction de l'origine et de l'extrémité
     * 
     * @param p_origine
     * @param p_extremite
     * @return true s'il est autorisé, false sinon
     */
    private boolean autorisationAssociation(EltGraphique p_origine , EltGraphique p_extremite) {
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }
    
     /**
     * méthode qui autorise le lien de dépendance
     * en fonction de l'origine et de l'extrémité
     * 
     * @param p_origine
     * @param p_extremite
     * @return true s'il est autorisé, false sinon
     */
    private boolean autorisationDependance(EltGraphique p_origine , EltGraphique p_extremite) {
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }
    
    /**
     * vérifie si l'élément est autorisé
     * 
     * @param p_element
     * @return true s'il est autorisé, false sinon
     */
    @Override
    public boolean eltAutorise (EltGraphique p_element){
        return ((p_element instanceof Traitement) || (p_element instanceof Lien) || (p_element instanceof ActeurPassif) || (p_element instanceof ActeurActif));       
    }
}
