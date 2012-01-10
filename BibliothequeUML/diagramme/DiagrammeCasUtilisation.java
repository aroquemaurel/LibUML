package diagramme;

import eltGraphique.ActeurActif;
import eltGraphique.CasUtilisation;
import eltGraphique.EltGraphique;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * Classe propre au diagramme de cas d'utilisation
 * 
 * @author satenske
 * @author Marie-Ly
 */
public class DiagrammeCasUtilisation extends Diagramme {
    
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
        if(p_typeDeFleche == TypeLien.ASSOCIATION){
                valeurRetour = this.autorisationAssociation(p_origine , p_extremite);
        } 
        else{
            if(p_typeDeFleche == TypeLien.GENERALISATION){
                valeurRetour = this.autorisationGeneralisation(p_origine , p_extremite);
            }
            else{
                if(p_typeDeFleche == TypeLien.DEPENDANCE){
                    valeurRetour = this.autorisationDependance(p_origine , p_extremite);
                }
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
        return((p_origine instanceof ActeurActif && p_extremite instanceof CasUtilisation) || (p_origine instanceof CasUtilisation && p_extremite instanceof ActeurActif) || (p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation));
    }
    
    /**
     * méthode qui autorise le lien de généralisation
     * en fonction de l'origine et de l'extrémité
     * 
     * @param p_origine
     * @param p_extremite
     * @return true s'il est autorisé, false sinon
     */
    private boolean autorisationGeneralisation(EltGraphique p_origine , EltGraphique p_extremite) {
        return(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation);
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
        return(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation);
    }
    
     /**
     * vérifie si l'élément est autorisé
     * 
     * @param p_element
     * @return true s'il est autorisé, false sinon
     */
    @Override
    public boolean eltAutorise (EltGraphique p_element){
        return ((p_element instanceof CasUtilisation) || (p_element instanceof Lien) || (p_element instanceof ActeurActif));  
    }
}
