package eltGraphique.ligne.fleche;

import com.mxgraph.view.mxGraph;
import eltGraphique.ElementModelisation;
import eltGraphique.ligne.LienPointille;

/**
 *
 * @author satenske
 */
public class FlechePointillee extends LienPointille {
    public FlechePointillee(ElementModelisation p_origine, ElementModelisation p_extremite, mxGraph p_graph){
        super(p_origine, p_extremite, p_graph);
    }
}
