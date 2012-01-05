package diagramme;

import eltGraphique.ActeurPassif;
import eltGraphique.EltGraphique;
import eltGraphique.Traitement;
import eltGraphique.classe.Classe;
import eltGraphique.ligne.Lien;

/**
 *
 * @author satenske
 */
public class DiagrammeSequence extends Diagramme {
    @Override
    public boolean lienAutorise (EltGraphique p_origine , EltGraphique p_extremite, String p_typeDeFleche){
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
    
    private boolean autorisationAssociation(EltGraphique p_origine , EltGraphique p_extremite) {
        boolean valeurRetour = false;
        if(p_origine instanceof Traitement && p_extremite instanceof Traitement){
            valeurRetour = true;
        }
        return(valeurRetour);
    }

    private boolean autorisationDependance(EltGraphique p_origine , EltGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof Traitement && p_extremite instanceof Traitement){
            valeurRetour = true;
        }
        return(valeurRetour);
    }
    @Override
    public boolean eltAutorise (EltGraphique p_element){
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
            }
        }
        return valeurRetour;       
    }
}
