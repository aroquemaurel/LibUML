package diagramme;

import eltGraphique.ElementGraphique;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import eltGraphique.eltModelisation.ActeurActif;
import eltGraphique.eltModelisation.ActeurPassif;
import eltGraphique.eltModelisation.Traitement;

/**
 * Cette classe permet de représenter et de manipuler <b>un Diagramme de Sequence</b>.
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeSequence extends Diagramme {
    
    /**
    * Méthode qui teste si le lien est autorisé ou non dans le diagrammme de
    * séquence en fonction de l'origine et de l'extrémité    
    *
    * @see Diagramme
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
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }
    
    /**
     * Méthode privée qui autorise un lien de type flèche en fonction de 
     * l'origine et de l'extrémité
     * 
     * @param p_origine Element graphique d'origine
     * @param p_extremite Element graphique d'arrivée
     * @return vrai(true) si le lien de type flèche entre deux éléments graphiques est autorisé
     * ou faux(false) si le lien de type flèche entre deux éléments graphiques n'est pas autorisé.
     */
    private boolean autorisationFleche(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }

    /**
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
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }
    
    /**
     * Méthode qui teste si l'élément est autorisé ou pas dans le diagramme
     * de séquence
     *
     * @see Diagramme
     * @param p_element
     * @return vrai(true) si l'element est autorisé dans un diagramme de sequence
     * ou faux(false) si l'element n'est pas autorisé dans un diagramme de sequence.
     */
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return ((p_element instanceof Traitement) || (p_element instanceof Lien) || (p_element instanceof ActeurPassif) || (p_element instanceof ActeurActif));       
    }
}
