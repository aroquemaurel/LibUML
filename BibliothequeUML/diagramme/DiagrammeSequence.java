package diagramme;

import eltGraphique.ActeurActif;
import eltGraphique.ActeurPassif;
import eltGraphique.ElementGraphique;
import eltGraphique.Traitement;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;

/**
 * @author satenske
 * @author Marie-Ly
 */
public class DiagrammeSequence extends Diagramme {
    
    public boolean lienAutorise (ElementGraphique p_origine , 
            ElementGraphique p_extremite, TypeLien p_typeDeFleche){
        boolean valeurRetour = false;
        switch (p_typeDeFleche){
            case ASSOCIATION:
                valeurRetour = this.autorisationAssociation(p_origine , 
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
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }

    private boolean autorisationDependance(ElementGraphique p_origine , 
            ElementGraphique p_extremite) {
        return(p_origine instanceof Traitement && p_extremite instanceof Traitement);
    }
    
    @Override
    public boolean eltAutorise (ElementGraphique p_element){
        return ((p_element instanceof Traitement) || (p_element instanceof Lien) || (p_element instanceof ActeurPassif) || (p_element instanceof ActeurActif));       
    }
}