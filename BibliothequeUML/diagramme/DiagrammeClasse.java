 package diagramme;

import eltGraphique.EltGraphique;
import eltGraphique.classe.Classe;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * Classe propre au diagramme de classe
 * 
 * @author satenske
 * @author Marie-Ly
 */
 
public class DiagrammeClasse extends Diagramme {
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
        if (p_typeDeFleche == TypeLien.COMPOSITION){
            valeurRetour = this.autorisationComposition(p_origine , p_extremite); 
        }
        else{
            if(p_typeDeFleche == TypeLien.ASSOCIATION){
                valeurRetour = this.autorisationAssociation(p_origine , p_extremite);
            } 
            else{
                if (p_typeDeFleche == TypeLien.AGREGATION){
                    valeurRetour = this.autorisationAgregation(p_origine , p_extremite);
                } 
                else{
                    if(p_typeDeFleche == TypeLien.GENERALISATION){
                        valeurRetour = this.autorisationGeneralisation(p_origine , p_extremite);
                    }
                    else{
                        if(p_typeDeFleche == TypeLien.DEPENDANCE){
                            valeurRetour = this.autorisationDependance( p_origine , p_extremite);
                        }
                    }
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
        return((p_origine instanceof Classe && p_extremite instanceof Classe) || (p_origine instanceof Classe && p_extremite instanceof Lien) || (p_origine instanceof Lien && p_extremite instanceof Classe));
    }
    
    /**
     * méthode qui autorise le lien d'agrégation
     * en fonction de l'origine et de l'extrémité
     * 
     * @param p_origine
     * @param p_extremite
     * @return true s'il est autorisé, false sinon
     */
    private boolean autorisationAgregation(EltGraphique p_origine , EltGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
    }
    
    /**
     * méthode qui autorise le lien de composition
     * en fonction de l'origine et de l'extrémité
     * 
     * @param p_origine
     * @param p_extremite
     * @return true s'il est autorisé, false sinon
     */
    private boolean autorisationComposition(EltGraphique p_origine , EltGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
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
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
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
        return((p_origine instanceof Classe && p_extremite instanceof Classe) || (p_origine instanceof Classe && p_extremite instanceof Lien) || (p_origine instanceof Lien && p_extremite instanceof Classe));
    }
    
    /**
     * vérifie si l'élément est autorisé
     * 
     * @param p_element
     * @return true s'il est autorisé, false sinon
     */
    @Override
    public boolean eltAutorise (EltGraphique p_element){
        return ((p_element instanceof Classe) || (p_element instanceof Lien));       
    }
}
