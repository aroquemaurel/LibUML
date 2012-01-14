package diagramme;

import eltGraphique.ActeurActif;
import eltGraphique.CasUtilisation;
import eltGraphique.ElementGraphique;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * Cette classe permet de représenter et de manipuler <b>un Diagramme de Cas d'utilisation</b>.
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeCasUtilisation extends Diagramme {
    
    /**
    * Méthode qui teste si le lien est autorisé ou non dans le diagrammme 
    * cas d'utilisation en fonction de l'origine et de l'extrémité
    * 
    * @see Diagramme.java
    * @param p_origine Element graphique d'origine
    * @param p_extremite Element graphique d'arrivée
    * @param p_typeDeFleche Type de lien utilisé entre les deux éléments graphiques
    * @return vrai(true) si le lien entre deux éléments graphiques est autorisé
    * ou faux(false) si le lien entre deux éléments graphiques n'est pas autorisé.
    */
    @Override
    public boolean lienAutorise (ElementGraphique p_origine , 
            ElementGraphique p_extremite, TypeLien p_typeDeFleche){
        boolean valeurRetour = false;
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
            default:
                valeurRetour = false;
        }
        return valeurRetour;
    }
    
    /**
     * 
     * Méthode privée qui autorise un lien d'association en fonction de 
     * l'origine et de l'extrémité
     * 
     * @param p_origine Element graphique d'origine
     * @param p_extremite Element graphique d'arrivée
     * @return vrai(true) si le lien d'association entre deux éléments graphiques est autorisé
     * ou faux(false) si le lien d'association entre deux éléments graphiques n'est pas autorisé.
     */
    private boolean autorisationAssociation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) { 
        return((p_origine instanceof ActeurActif && p_extremite instanceof CasUtilisation) || 
               (p_origine instanceof CasUtilisation && p_extremite instanceof ActeurActif) || 
               (p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation));
    }

    /**
     * 
     * Méthode privée qui autorise un lien de généralisation en fonction de 
     * l'origine et de l'extrémité
     * 
     * @param p_origine Element graphique d'origine
     * @param p_extremite Element graphique d'arrivée
     * @return vrai(true) si le lien de generalisation entre deux éléments graphiques est autorisé
     * ou faux(false) si le lien de generalisation entre deux éléments graphiques n'est pas autorisé.
     */
    private boolean autorisationGeneralisation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation);
    }

    /**
     * 
     * Méthode privée qui autorise un lien de dépendance en fonction de 
     * l'origine et de l'extrémité
     * 
     * @param p_origine Element graphique d'origine
     * @param p_extremite Element graphique d'arrivée
     * @return vrai(true) si le lien de dependance entre deux éléments graphiques est autorisé
     * ou faux(false) si le lien de dependance entre deux éléments graphiques n'est pas autorisé.
     */
    private boolean autorisationDependance(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation);
    }
    
    /**
     * Méthode qui teste si l'élément est autorisé ou pas dans le diagramme
     * cas d'utilisation
     * @see Diagramme.java
     * @param p_element
     * @return vrai(true) si l'element est autorisé dans un diagramme de cas d'utilisation
     * ou faux(false) si l'element n'est pas autorisé dans un diagramme de cas d'utilisation.
     */
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return((p_element instanceof CasUtilisation) || (p_element instanceof Lien) || (p_element instanceof ActeurActif));  
    }
}