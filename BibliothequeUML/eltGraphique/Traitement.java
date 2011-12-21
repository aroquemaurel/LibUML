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
        super.graph = p_graph;
        super.setNom(p_nom);
    }
}
