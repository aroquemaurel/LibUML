package diagramme;

import eltGraphique.ElementGraphique;
import eltGraphique.eltModelisation.ActeurActif;
import eltGraphique.eltModelisation.ActeurPassif;
import eltGraphique.eltModelisation.Traitement;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * Cette classe permet de représenter et de manipuler <b>un Diagramme de Sequence</b>.
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeSequence extends Diagramme {
    
    /**
    * Méthode qui teste si le lien est autorisé dans le diagrammme de
    * séquence, en fonction de l'origine et de l'extrémité
	* 
	* Méthode surchargée de Diagramme
    *
    * @param p_origine Elément graphique d'origine
    * @param p_extremite Elément graphique d'arrivée
    * @param p_typeDeFleche Type de lien utilisé entre les deux éléments graphiques
    * @return Vrai si le lien entre les deux éléments graphiques est autorisé, faux sinon
	* 
    * @see Diagramme
    */
    @Override
    public boolean lienAutorise (ElementGraphique p_origine , 
            ElementGraphique p_extremite, TypeLien p_typeDeFleche){
        boolean valeurRetour;
        
        switch (p_typeDeFleche){
            case ASSOCIATION:
                valeurRetour = this.autorisationAssociation(p_origine, p_extremite);
                break; 
            case DEPENDANCE:
                valeurRetour = this.autorisationDependance(p_origine, p_extremite);
                break;
            case FLECHE:
                valeurRetour = this.autorisationFleche(p_origine, p_extremite);
                break;
            default:
                valeurRetour = false;
        }
        return valeurRetour;
    }
    
     /**
     * Méthode privée qui teste si un lien d'association, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Element graphique d'origine
     * @param p_extremite Element graphique d'arrivée
     * @return Vrai si le lien d'association entre les deux éléments graphiques est autorisé, faux sinon
     */
    private boolean autorisationAssociation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }
    
    /**
     * Méthode privée qui teste si un lien de type flèche, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Elément graphique d'origine
     * @param p_extremite Elément graphique d'arrivée
     * @return Vrai si le lien de type flèche entre les deux éléments graphiques est autorisé, faux sinon
     */
    private boolean autorisationFleche(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }

    /**
     * Méthode privée qui test si un lien de dépendance, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Elément graphique d'origine
     * @param p_extremite Elément graphique d'arrivée
     * @return Vrai si le lien de dependance entre les deux éléments graphiques est autorisé, faux sinon
     */
    private boolean autorisationDependance(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }
    
    /**
     * Méthode qui teste si l'élément est autorisé dans le diagramme
     * de séquence
     *
     * @param p_element L'élément à tester
     * @return Vrai si l'élément est autorisé dans un diagramme de sequence, faux sinon
	 * 
     * @see Diagramme
     */
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return ((p_element instanceof Traitement) || (p_element instanceof Lien) || (p_element instanceof ActeurPassif) || (p_element instanceof ActeurActif));       
    }
    
    @Override
    public String toString(){
        return ("Diagramme de séquence");
    }
}
