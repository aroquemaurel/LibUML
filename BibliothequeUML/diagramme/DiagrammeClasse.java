 package diagramme;

import eltGraphique.EltGraphique;
import eltGraphique.classe.Classe;
import eltGraphique.ligne.Lien;

/**
 *
 * @author satenske
 */
 
public class DiagrammeClasse extends Diagramme {
    @Override
    public boolean lienAutorise (EltGraphique p_origine , EltGraphique p_extremite, String p_typeDeFleche){
        boolean valeurRetour = false;
        if ("composition".equals(p_typeDeFleche)){
            valeurRetour = this.autorisationComposition(p_origine , p_extremite); 
        }
        else{
            if("association".equals(p_typeDeFleche)){
                valeurRetour = this.autorisationAssociation(p_origine , p_extremite);
            } 
            else{
                if ("agrégation".equals(p_typeDeFleche)){
                    valeurRetour = this.autorisationAgregation(p_origine , p_extremite);
                } 
                else{
                    if("généralisation".equals(p_typeDeFleche)){
                        valeurRetour = this.autorisationGeneralisation(p_origine , p_extremite);
                    }
                    else{
                        if("dependance".equals(p_typeDeFleche)){
                            valeurRetour = this.autorisationDependance( p_origine , p_extremite);
                        }
                    }
                }
            }
        }        
        return valeurRetour;
    }
    
    private boolean autorisationAssociation(EltGraphique p_origine , EltGraphique p_extremite) {
        boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        if(p_origine instanceof Classe && p_extremite instanceof Lien){
            valeurRetour = true;
        }
        if(p_origine instanceof Lien && p_extremite instanceof Classe){
            valeurRetour = true;
        }     
        return(valeurRetour);
    }

    private boolean autorisationAgregation(EltGraphique p_origine , EltGraphique p_extremite) {
        boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        return(valeurRetour);
    }

    private boolean autorisationComposition(EltGraphique p_origine , EltGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        return(valeurRetour);
    }

    private boolean autorisationGeneralisation(EltGraphique p_origine , EltGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        return(valeurRetour);
    }

    private boolean autorisationDependance(EltGraphique p_origine , EltGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        if(p_origine instanceof Classe && p_extremite instanceof Lien){
            valeurRetour = true;
        }
        if(p_origine instanceof Lien && p_extremite instanceof Classe){
            valeurRetour = true;
        }     
        return(valeurRetour);
    }
    @Override
    public boolean eltAutorise (EltGraphique p_element){
        boolean valeurRetour = false;
        if(p_element instanceof Classe){
            valeurRetour = true;
        }
        else{
            if(p_element instanceof Lien){
                valeurRetour = true;
            }
        }
        return valeurRetour;       
    }
}
