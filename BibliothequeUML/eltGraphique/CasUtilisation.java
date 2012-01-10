package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

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
    public CasUtilisation(mxGraph p_graph, Diagramme p_diagramme, String p_texte) {
		super(p_graph, p_diagramme, p_texte, new Dimension(150,75));
    }

	/**
	 * Crée la représentation graphique du cas d'utilisation
	 */
	@Override
    public final void creer(){
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();

		nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
		nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
		nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		feuilleStyles.putCellStyle("USECASE", nouveauStyle);
		
        super.setCellule((mxCell) super.getGraph().insertVertex(
            super.getParent(), null, super.getTexte(), 30, 30,
			super.getDimension().getWidth(), super.getDimension().getHeight(),
			"USECASE"));
    }

}
