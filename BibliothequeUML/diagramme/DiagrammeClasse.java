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
    public boolean lienAutorise (EltGraphique origine , EltGraphique extremite){
        boolean valeurRetour = false;
        if(origine instanceof Classe && extremite instanceof Classe){
            valeurRetour = true;
        }
        if(origine instanceof Lien && extremite instanceof Classe){
            valeurRetour = true;
        }
        
        return(valeurRetour);
    }
}
