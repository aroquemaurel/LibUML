package diagramme;

import eltGraphique.ActeurActif;
import eltGraphique.CasUtilisation;
import eltGraphique.ElementGraphique;
import eltGraphique.ligne.Lien;

/**
 *
 * @author satenske
 */
public class DiagrammeCasUtilisation extends Diagramme {
    @Override
    public boolean lienAutorise (ElementGraphique p_origine , ElementGraphique p_extremite, String p_typeDeFleche){
        boolean valeurRetour = false;
        if("association".equals(p_typeDeFleche)){
                valeurRetour = this.autorisationAssociation(p_origine , p_extremite);
        } 
        else{
            if("généralisation".equals(p_typeDeFleche)){
                valeurRetour = this.autorisationGeneralisation(p_origine , p_extremite);
            }
            else{
                if("dependance".equals(p_typeDeFleche)){
                    valeurRetour = this.autorisationDependance(p_origine , p_extremite);
                }
            }
        }    
        return valeurRetour;
    }
    
    private boolean autorisationAssociation(ElementGraphique p_origine , ElementGraphique p_extremite) {
        boolean valeurRetour = false;
        if(p_origine instanceof ActeurActif && p_extremite instanceof CasUtilisation){
            valeurRetour = true;
        }
        if(p_origine instanceof CasUtilisation && p_extremite instanceof ActeurActif){
            valeurRetour = true;
        }
        if(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation){
            valeurRetour = true;
        }     
        return(valeurRetour);
    }

    private boolean autorisationGeneralisation(ElementGraphique p_origine , ElementGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation){
            valeurRetour = true;
        }
        return(valeurRetour);
    }

    private boolean autorisationDependance(ElementGraphique p_origine , ElementGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation){
            valeurRetour = true;
        }
        return(valeurRetour);
    }
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        boolean valeurRetour = false;
        if(p_element instanceof CasUtilisation){
            valeurRetour = true;
        }
        else{
            if(p_element instanceof Lien){
                valeurRetour = true;
            }
            else{
                if(p_element instanceof ActeurActif){
                    valeurRetour = true;
                }
            }
        }
        return valeurRetour;  
    }
}
