package diagramme;

import eltGraphique.ActeurActif;
import eltGraphique.CasUtilisation;
import eltGraphique.EltGraphique;
import eltGraphique.ligne.Lien;

/**
 *
 * @author satenske
 */
public class DiagrammeCasUtilisation extends Diagramme {
    @Override
    public boolean lienAutorise (EltGraphique p_origine , EltGraphique p_extremite, String p_typeDeFleche){
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
    
    private boolean autorisationAssociation(EltGraphique p_origine , EltGraphique p_extremite) {
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

    private boolean autorisationGeneralisation(EltGraphique p_origine , EltGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation){
            valeurRetour = true;
        }
        return(valeurRetour);
    }

    private boolean autorisationDependance(EltGraphique p_origine , EltGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof CasUtilisation && p_extremite instanceof CasUtilisation){
            valeurRetour = true;
        }
        return(valeurRetour);
    }
    @Override
    public boolean eltAutorise (EltGraphique p_element){
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
