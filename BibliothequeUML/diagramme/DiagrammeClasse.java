 package diagramme;

import eltGraphique.EltGraphique;
import eltGraphique.classe.Classe;
import eltGraphique.ligne.Lien;

/**
 * Classe propre au diagramme de classe
 * 
 * @author satenske
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
    public boolean lienAutorise (EltGraphique p_origine , EltGraphique p_extremite, String p_typeDeFleche){
        boolean valeurRetour = false;
        if ("composition".equals(p_typeDeFleche)){
            valeurRetour = this.autorisationComposition(p_origine , p_extremite); 
        }
        else{
            if("association".equals(p_typeDeFleche)){
                valeurRetour = this.autorisationAssociation(p_origine , p_extremite);
            } 
            else{
                if ("agrégation".equals(p_typeDeFleche)){
                    valeurRetour = this.autorisationAgregation(p_origine , p_extremite);
                } 
                else{
                    if("généralisation".equals(p_typeDeFleche)){
                        valeurRetour = this.autorisationGeneralisation(p_origine , p_extremite);
                    }
                    else{
                        if("dependance".equals(p_typeDeFleche)){
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
        boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        if(p_origine instanceof Classe && p_extremite instanceof Lien){
            valeurRetour = true;
        }
        if(p_origine instanceof Lien && p_extremite instanceof Classe){
            valeurRetour = true;
        }     
        return(valeurRetour);
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
        boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        return(valeurRetour);
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
           boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        return(valeurRetour);
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
           boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        return(valeurRetour);
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
           boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        if(p_origine instanceof Classe && p_extremite instanceof Lien){
            valeurRetour = true;
        }
        if(p_origine instanceof Lien && p_extremite instanceof Classe){
            valeurRetour = true;
        }     
        return(valeurRetour);
    }
    
    /**
     * vérifie si l'élément est autorisé
     * 
     * @param p_element
     * @return true s'il est autorisé, false sinon
     */
    @Override
    public boolean eltAutorise (EltGraphique p_element){
        boolean valeurRetour = false;
        if(p_element instanceof Classe){
            valeurRetour = true;
        }
        else{
            if(p_element instanceof Lien){
                valeurRetour = true;
            }
        }
        return valeurRetour;       
    }
}
