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
    
    private boolean autorisationAssociation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) { 
        return((p_origine instanceof ActeurActif && p_extremite instanceof CasUtilisation) || (p_origine instanceof CasUtilisation && p_extremite instanceof ActeurActif) || (p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation));
    }

    private boolean autorisationGeneralisation(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation);
    }

    private boolean autorisationDependance(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation);
    }
    
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return((p_element instanceof CasUtilisation) || (p_element instanceof Lien) || (p_element instanceof ActeurActif));  
    }
}