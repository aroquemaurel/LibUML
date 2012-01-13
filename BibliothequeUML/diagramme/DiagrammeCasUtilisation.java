package diagramme;

import eltGraphique.ActeurActif;
import eltGraphique.CasUtilisation;
import eltGraphique.ElementGraphique;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * @author satenske
 * @author Marie-Ly
 */
public class DiagrammeCasUtilisation extends Diagramme {
    
    /**
     * Méthode qui teste si le lien est autorisé ou non dans le diagrammme 
     * cas d'utilisation en fonction de l'origine et de l'extrémité
     * 
     * @see Diagramme.java
     * @param p_origine
     * @param p_extremite
     * @param p_typeDeFleche
     * @return true s'il est, false sinon
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
        return((p_origine instanceof ActeurActif && p_extremite instanceof CasUtilisation) || (p_origine instanceof CasUtilisation && p_extremite instanceof ActeurActif) || (p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation));
    }

    /**
     * 
     * Méthode privée qui autorise un lien de généralisation en fonction de 
     * l'origine et de l'extrémité
     * 
     * @param p_origine
     * @param p_extremite
     * @return le lien d'association lorsque les p_origne et p_extremité sont 
     * corrects
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
     * @param p_origine
     * @param p_extremite
     * @return le lien d'association lorsque les p_origne et p_extremité sont 
     * corrects
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
     * @return true s'il est, false sinon
     */
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return((p_element instanceof CasUtilisation) || (p_element instanceof Lien) || (p_element instanceof ActeurActif));  
    }
}