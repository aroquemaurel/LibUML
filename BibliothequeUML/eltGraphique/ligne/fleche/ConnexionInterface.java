package eltGraphique.ligne.fleche;

import com.mxgraph.view.mxGraph;
import eltGraphique.ElementModelisation;
import eltGraphique.ligne.ArcCercle;

/**
 *
 * @author satenske
 */
public class ConnexionInterface extends ArcCercle {
    public ConnexionInterface(ElementModelisation p_origine, ElementModelisation p_extremite, mxGraph p_graph){
        super(p_origine, p_extremite, p_graph);
    }

    @Override
    public void creer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void creer(String p_style) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
