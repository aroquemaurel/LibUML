package diagramme;

import eltGraphique.ElementGraphique;
import eltGraphique.classe.Classe;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * Cette classe permet de représenter et de manipuler <b>un Diagramme de Classe</b>.
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeClasse extends Diagramme {

    /**
    * Cette classe permet de représenter et de manipuler <b>un Diagramme de Classe</b>.
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
            case GENERALISATION:
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
        return((p_origine instanceof Classe && p_extremite instanceof Classe));
    }

    /**
     * 
     * Méthode privée qui autorise un lien d'agregation en fonction de 
     * l'origine et de l'extrémité
     * 
     * @param p_origine Element graphique d'origine
     * @param p_extremite Element graphique d'arrivée
     * @return vrai(true) si le lien d'agregation entre deux éléments graphiques est autorisé
     * ou faux(false) si le lien d'agregation entre deux éléments graphiques n'est pas autorisé.
     */
    private boolean autorisationAgregation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
    }

    /**
     * 
     * Méthode privée qui autorise un lien de classe association en fonction de 
     * l'origine et de l'extrémité
     * 
     * @param p_origine Element graphique d'origine
     * @param p_extremite Element graphique d'arrivée
     * @return vrai(true) si le lien de classe association entre deux éléments graphiques est autorisé
     * ou faux(false) si le lien de classe association entre deux éléments graphiques n'est pas autorisé.
     */
    private boolean autorisationClasseAssociation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Lien
            || p_origine instanceof Lien && p_extremite instanceof Classe);
    }

    
    /**
     * 
     * Méthode privée qui autorise un lien de composition en fonction de 
     * l'origine et de l'extrémité
     * 
     * @param p_origine Element graphique d'origine
     * @param p_extremite Element graphique d'arrivée
     * @return vrai(true) si le lien de composition entre deux éléments graphiques est autorisé
     * ou faux(false) si le lien de composition entre deux éléments graphiques n'est pas autorisé.
     */
    private boolean autorisationComposition(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
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
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
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
        return((p_origine instanceof Classe && p_extremite instanceof Classe) ||
                (p_origine instanceof Classe && p_extremite instanceof Lien) || 
                (p_origine instanceof Lien && p_extremite instanceof Classe));
    }
       
     /**
     * Méthode qui teste si l'élément est autorisé ou pas dans le diagramme
     * de classe
     * @see Diagramme.java
     * @param p_element
     * @return vrai(true) si l'element est autorisé dans un diagramme de classe
     * ou faux(false) si l'element n'est pas autorisé dans un diagramme de classe.
     */
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return ((p_element instanceof Classe) || (p_element instanceof Lien));       
    }
}
