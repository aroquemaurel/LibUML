package eltGraphique.ligne;

import com.mxgraph.view.mxGraph;
import eltGraphique.ElementModelisation;

/**
 *
 * @author satenske
 */
public class LienPointille extends Lien {
    public LienPointille(ElementModelisation p_origine, ElementModelisation p_extremite, mxGraph p_graph){
        super(p_origine, p_extremite, p_graph);
    }
}
