package eltGraphique;

import com.mxgraph.view.mxGraph;
import eltGraphique.ligne.Lien;

/**
 *
 * @author satenske
 */
public class Traitement extends ElementModelisation {
	private Lien evenementDeclencheur;
    
    public Traitement(String p_nom, mxGraph p_graph){
        super(p_nom, p_graph);
    }

    @Override
    public void creer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
