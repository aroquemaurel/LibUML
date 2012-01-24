package diagramme;

import eltGraphique.ElementGraphique;
import eltGraphique.eltModelisation.Classe;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * Cette classe permet de représenter et de manipuler <b>un Diagramme de Classe</b>.
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeClasse extends Diagramme {

    /**
    * Méthode qui teste si le lien est autorisé dans le diagrammme de 
    * classe, en fonction de l'origine et de l'extrémité
	* 
	* Méthode surchargée de Diagramme
    * 
    * @param p_origine Elément graphique d'origine
    * @param p_extremite Elément graphique d'arrivée
    * @param p_typeDeLien Type de lien utilisé entre les deux éléments graphiques
    * @return Vrai si le lien entre les deux éléments graphiques est autorisé, faux sinon
	* 
	* @see eltGraphique.ElementGraphique
	* @see eltGraphique.ligne.TypeLien
    */
    @Override
    public boolean lienAutorise (ElementGraphique p_origine , 
            ElementGraphique p_extremite, TypeLien p_typeDeLien){
        boolean valeurRetour;
        switch (p_typeDeLien){
            case COMPOSITION: 
            valeurRetour = this.autorisationComposition(p_origine , p_extremite);
            break;
            case ASSOCIATION:
                valeurRetour = this.autorisationAssociation(p_origine , 
                        p_extremite); 
                break;
            case CLASSE_ASSOCIATION:
                valeurRetour = this.autorisationClasseAssociation(p_origine , 
                        p_extremite); 
                break;
            case SPECIALISATION:
                valeurRetour = this.autorisationGeneralisation(p_origine , 
                        p_extremite);
                break;
            case DEPENDANCE:
                valeurRetour = this.autorisationDependance(p_origine , 
                        p_extremite);
                break;
            case AGREGATION:
                valeurRetour = this.autorisationAgregation(p_origine , 
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
     * @param p_origine Elément graphique d'origine
     * @param p_extremite Elément graphique d'arrivée
     * @return Vrai si le lien d'association entre les deux éléments graphiques est autorisé, faux sinon
     */
    private boolean autorisationAssociation(ElementGraphique p_origine ,
            ElementGraphique p_extremite) {   
        return((p_origine instanceof Classe && p_extremite instanceof Classe));
    }

    /**
     * 
     * Méthode privée qui test si un lien d'agrégation, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Elément graphique d'origine
     * @param p_extremite Elément graphique d'arrivée
     * @return Vrai si le lien d'agregation entre les deux éléments graphiques est autorisé, faux sinon
     */
    private boolean autorisationAgregation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
    }

    /**
     * 
     * Méthode privée qui teste si un lien de classe association, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Elément graphique d'origine
     * @param p_extremite Elément graphique d'arrivée
     * @return Vrai si le lien de classe association entre les deux éléments graphiques est autorisé, faux sinon
     */
    private boolean autorisationClasseAssociation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Lien
            || p_origine instanceof Lien && p_extremite instanceof Classe);
    }

    
    /**
     * 
     * Méthode privée qui teste si un lien de composition, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Elément graphique d'origine
     * @param p_extremite Elément graphique d'arrivée
     * @return Vrai si le lien de composition entre les deux éléments graphiques est autorisé, faux sinon
     */
    private boolean autorisationComposition(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
    }

    /**
     * 
     * Méthode privée qui teste si un lien de généralisation, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Elément graphique d'origine
     * @param p_extremite Elément graphique d'arrivée
     * @return Vrai si le lien de generalisation entre les deux éléments graphiques est autorisé, faux sinon
     */
    private boolean autorisationGeneralisation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
    }

    /**
     * 
     * Méthode privée qui teste si un lien de dépendance, en fonction de 
     * l'origine et de l'extrémité, est autorisé
     * 
     * @param p_origine Elément graphique d'origine
     * @param p_extremite Elément graphique d'arrivée
     * @return Vrai si le lien de dependance entre deux éléments graphiques est autorisé, faux sinon
     */
    private boolean autorisationDependance(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {   
        return((p_origine instanceof Classe && p_extremite instanceof Classe) ||
                (p_origine instanceof Classe && p_extremite instanceof Lien) || 
                (p_origine instanceof Lien && p_extremite instanceof Classe));
    }
       
     /**
     * Méthode qui teste si l'élément est autorisé dans le diagramme de classe
	* 
	* Méthode surchargée de Diagramme
	 * 
     * @param p_element L'élément à tester
     * @return Vrai si l'élément est autorisé dans un diagramme de classe, faux sinon
	 * 
     * @see Diagramme
     */
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return ((p_element instanceof Classe) || (p_element instanceof Lien));       
    }
    
    @Override
    public String toString(){
        return ("Diagramme de classes");
    }
}
