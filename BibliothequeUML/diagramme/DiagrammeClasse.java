 package diagramme;

import eltGraphique.ElementGraphique;
import eltGraphique.classe.Classe;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * Cette classe permet de représenter et de manipuler <b>un Diagramme de Classe</b>.
 * @author satenske
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
    * ou faux(false) si le liens entre deux éléments graphiques n'est pas autorisé.
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
        }
        return valeurRetour;
    }
    
    private boolean autorisationAssociation(ElementGraphique p_origine ,
            ElementGraphique p_extremite) {   
        return((p_origine instanceof Classe && p_extremite instanceof Classe) ||
                (p_origine instanceof Classe && p_extremite instanceof Lien) ||
                (p_origine instanceof Lien && p_extremite instanceof Classe));
    }

    private boolean autorisationAgregation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
    }

    private boolean autorisationComposition(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
    }

    private boolean autorisationGeneralisation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Classe && p_extremite instanceof Classe);
    }

    private boolean autorisationDependance(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {   
        return((p_origine instanceof Classe && p_extremite instanceof Classe) ||
                (p_origine instanceof Classe && p_extremite instanceof Lien) || 
                (p_origine instanceof Lien && p_extremite instanceof Classe));
    }
           
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return ((p_element instanceof Classe) || (p_element instanceof Lien));       
    }
}
