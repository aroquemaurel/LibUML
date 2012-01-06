package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;

/**
 * Modélise un cas d'utilisation par une ellipse et un texte
 *
 */
public class CasUtilisation extends ElementModelisation {

	/**
	 * Constructeur de la classe CasUtilisation
	 * @param p_graph Le graphe auquel sera ajouté le cas d'utilisation
	 * @param p_texte Le texte qui sera associé au cas d'utilisation
	 */
    public CasUtilisation(mxGraph p_graph, String p_texte) {
		super(p_graph, p_texte, new Dimension(150,75));
    }

	/**
	 * Crée la représentation graphique du cas d'utilisation
	 */
	@Override
    public final void creer(){
        super.setCellule((mxCell) this.graph.insertVertex(
            super.getParent(), null, super.getTexte(), 30, 30,
			super.getDimension().getWidth(), super.getDimension().getHeight(),
			"USECASE"));
    }

}
