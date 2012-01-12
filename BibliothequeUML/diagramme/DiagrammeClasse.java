 package diagramme;

import eltGraphique.ElementGraphique;
import eltGraphique.classe.Classe;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 *
 * @author satenske
 * @author Marie-Ly
 */
 
public class DiagrammeClasse extends Diagramme {
    
    public boolean lienAutorise (ElementGraphique p_origine , ElementGraphique p_extremite, TypeLien p_typeDeFleche){
        boolean valeurRetour = false;
        switch (p_typeDeFleche){
            case COMPOSITION: 
            valeurRetour = this.autorisationComposition(p_origine , p_extremite);
            case ASSOCIATION:
                valeurRetour = this.autorisationAssociation(p_origine , p_extremite); 
                break;
            case GENERALISATION:
                valeurRetour = this.autorisationGeneralisation(p_origine , p_extremite);
                break;
            case DEPENDANCE:
                valeurRetour = this.autorisationDependance(p_origine , p_extremite);
            case AGREGATION:
                valeurRetour = this.autorisationAgregation(p_origine , p_extremite);    
        }
        return valeurRetour;
    }
    
    private boolean autorisationAssociation(ElementGraphique p_origine , ElementGraphique p_extremite) {
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

    private boolean autorisationAgregation(ElementGraphique p_origine , ElementGraphique p_extremite) {
        boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        return(valeurRetour);
    }

    private boolean autorisationComposition(ElementGraphique p_origine , ElementGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        return(valeurRetour);
    }

    private boolean autorisationGeneralisation(ElementGraphique p_origine , ElementGraphique p_extremite) {
           boolean valeurRetour = false;
        if(p_origine instanceof Classe && p_extremite instanceof Classe){
            valeurRetour = true;
        }
        return(valeurRetour);
    }

    private boolean autorisationDependance(ElementGraphique p_origine , ElementGraphique p_extremite) {
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
    public boolean eltAutorise (ElementGraphique p_element){
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
