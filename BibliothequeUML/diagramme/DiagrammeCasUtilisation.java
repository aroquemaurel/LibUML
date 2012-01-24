package diagramme;

import eltGraphique.ElementGraphique;
import eltGraphique.eltModelisation.ActeurActif;
import eltGraphique.eltModelisation.CasUtilisation;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * Cette classe permet de représenter et de manipuler <b>un Diagramme de Cas d'utilisation</b>.
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeCasUtilisation extends Diagramme {
    
    /**
    * Méthode qui teste si le lien est autorisé dans le diagrammme de 
    * cas d'utilisation, en fonction de l'origine et de l'extrémité
	* 
	* Méthode surchargée de Diagramme
    * 
    * @param p_origine Elément graphique d'origine
    * @param p_extremite Elément graphique d'arrivée
    * @param p_typeDeFleche Type de lien utilisé entre les deux éléments graphiques
    * @return Vrai si la combinaison est autorisée, faux sinon
	* 
    * @see Diagramme
    */
    @Override
    public boolean lienAutorise (ElementGraphique p_origine , 
            ElementGraphique p_extremite, TypeLien p_typeDeFleche){
        boolean valeurRetour;
        switch (p_typeDeFleche){
            case ASSOCIATION:
                valeurRetour = this.autorisationAssociation(p_origine , 
                        p_extremite); 
                break;
            case GENERALISATION:
                valeurRetour = this.autorisationGeneralisation(p_origine , 
                        p_extremite);
                break;
            case DEPENDANCE:
                valeurRetour = this.autorisationDependance(p_origine , 
                        p_extremite);
                break;
            default:
                valeurRetour = false;
        }
        return valeurRetour;
    }
    
    /**
     * 
     * Méthode privée qui teste si un lien d'association, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Element graphique d'origine
     * @param p_extremite Element graphique d'arrivée
     * @return Vrai si le lien d'association entre les deux éléments
	 * graphiques est autorisé faux sinon
     */
    private boolean autorisationAssociation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) { 
        return((p_origine instanceof ActeurActif && p_extremite instanceof CasUtilisation) || 
               (p_origine instanceof CasUtilisation && p_extremite instanceof ActeurActif) || 
               (p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation));
    }

    /**
     * 
     * Méthode privée qui teste si un lien de généralisation, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Elément graphique d'origine
     * @param p_extremite Elément graphique d'arrivée
     * @return Vrai si le lien de generalisation entre les
	 * deux éléments graphiques est autorisé faux sinon
	 * 
	 * @see eltGraphique.ElementGraphique
	 * @see eltGraphique.ligne.TypeLien
     */
    private boolean autorisationGeneralisation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation);
    }

    /**
     * 
     * Méthode privée qui teste si un lien de dépendance, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Elément graphique d'origine
     * @param p_extremite Elément graphique d'arrivée
     * @return Vrai si le lien de dependance entre les deux éléments graphiques est autorisé, faux sinon
     */
    private boolean autorisationDependance(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation);
    }
    
    /**
     * Méthode qui teste si l'élément est autorisé dans un diagramme de
     * cas d'utilisation
	* 
	* Méthode surchargée de Diagramme
	 * 
     * @param p_element L'élément à tester
     * @return Vrai si l'élément est autorisé dans un diagramme de cas
	 * d'utilisation, faux sinon
	 * 
     * @see Diagramme
     */
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return((p_element instanceof CasUtilisation) || (p_element instanceof Lien) || (p_element instanceof ActeurActif));  
    }
    
    @Override
    public String toString(){
        return ("Diagramme de cas d'utilisation");
    }
        
}
