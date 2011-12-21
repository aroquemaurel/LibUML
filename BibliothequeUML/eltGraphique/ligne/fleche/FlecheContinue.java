package eltGraphique.ligne.fleche;

import com.mxgraph.view.mxGraph;
import eltGraphique.ElementModelisation;
import eltGraphique.ligne.LienContinu;

/**
 *
 * @author satenske
 */
public class FlecheContinue extends LienContinu {
    private String typeFleche;
    
    public FlecheContinue(ElementModelisation p_origine, ElementModelisation p_extremite, 
        mxGraph p_graph, String p_typeFleche){
        super(p_origine, p_extremite, p_graph);
        super.cellule.setStyle(p_typeFleche);
        this.typeFleche = p_typeFleche;
    }

}
