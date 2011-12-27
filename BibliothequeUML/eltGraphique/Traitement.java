package eltGraphique;

import com.mxgraph.view.mxGraph;
import eltGraphique.ligne.Lien;

/**
 *
 * @author satenske
 */
public class Traitement extends ElementModelisation {
	private Lien evenementDeclencheur;
    
    public Traitement(mxGraph p_graph, String p_nom){
        super(p_graph, p_nom);
		this.creer();
    }

    @Override
    public void creer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
