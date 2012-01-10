package diagramme;

import eltGraphique.ActeurActif;
import eltGraphique.ActeurPassif;
import eltGraphique.ElementGraphique;
import eltGraphique.Traitement;
import eltGraphique.ligne.Lien;

/**
 *
 * @author satenske
 */
public class DiagrammeSequence extends Diagramme {
    @Override
    public boolean lienAutorise (ElementGraphique p_origine , ElementGraphique p_extremite, String p_typeDeFleche){
        boolean valeurRetour = false;
        if ("association".equals(p_typeDeFleche)){
            valeurRetour = this.autorisationAssociation(p_origine , p_extremite); 
        }
        else{
            if("dependance".equals(p_typeDeFleche)){
                valeurRetour = this.autorisationDependance( p_origine , p_extremite);
            }
        }      
        return valeurRetour;
    }
    
    private boolean autorisationAssociation(ElementGraphique p_origine , ElementGraphique p_extremite) {
        boolean valeurRetour = false;
        if(p_origine instanceof Traitement && p_extremite instanceof Traitement){
            valeurRetour = true;
        }
        return(valeurRetour);
    }

    private boolean autorisationDependance(ElementGraphique p_origine , ElementGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof Traitement && p_extremite instanceof Traitement){
            valeurRetour = true;
        }
        return(valeurRetour);
    }
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        boolean valeurRetour = false;
        if(p_element instanceof Traitement){
            valeurRetour = true;
        }
        else{
            if(p_element instanceof Lien){
                valeurRetour = true;
            }
            else{
                if(p_element instanceof ActeurPassif){
                    valeurRetour = true;
                }
                else{
                    if(p_element instanceof ActeurActif){
                        valeurRetour = true;
                    }
                }
            }
        }
        return valeurRetour;       
    }
}
