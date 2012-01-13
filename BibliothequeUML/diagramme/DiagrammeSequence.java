package diagramme;

import eltGraphique.ActeurActif;
import eltGraphique.ActeurPassif;
import eltGraphique.ElementGraphique;
import eltGraphique.Traitement;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * @author satenske
 * @author Marie-Ly
 */
public class DiagrammeSequence extends Diagramme {
    
    /**
     * Méthode qui teste si le lien est autorisé ou non dans le diagrammme de
     * séquence en fonction de l'origine et de l'extrémité
     * @see Diagramme.java
     * @param p_origine
     * @param p_extremite
     * @param p_typeDeFleche
     * @return true s'il est, false sinon
     */
    public boolean lienAutorise (ElementGraphique p_origine , 
            ElementGraphique p_extremite, TypeLien p_typeDeFleche){
        boolean valeurRetour = false;
        switch (p_typeDeFleche){
            case ASSOCIATION:
                valeurRetour = this.autorisationAssociation(p_origine , 
                        p_extremite); 
                break;
            case DEPENDANCE:
                valeurRetour = this.autorisationDependance(p_origine , 
                        p_extremite);
        }
        return valeurRetour;
    }
    
     /**
     * 
     * Méthode privée qui autorise un lien d'association en fonction de 
     * l'origine et de l'extrémité
     * 
     * @param p_origine
     * @param p_extremite
     * @return le lien d'association lorsque les p_origne et p_extremité sont 
     * corrects
     */
    private boolean autorisationAssociation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }

    /**
     * 
     * Méthode privée qui autorise un lien de dépendance en fonction de 
     * l'origine et de l'extrémité
     * 
     * @param p_origine
     * @param p_extremite
     * @return le lien d'association lorsque les p_origne et p_extremité sont 
     * corrects
     */
    private boolean autorisationDependance(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }
    
    /**
     * Méthode qui teste si l'élément est autorisé ou pas dans le diagramme
     * de séquence
     * @see Diagramme.java
     * @param p_element
     * @return true s'il est, false sinon
     */
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return ((p_element instanceof Traitement) || (p_element instanceof Lien) || (p_element instanceof ActeurPassif) || (p_element instanceof ActeurActif));       
    }
}