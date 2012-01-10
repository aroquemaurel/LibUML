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
 * Classe propre aux acteurs passif (représentation graphique)
 *
 * @see Acteur
 * @see ActeurPassif
 *
 */
public class ActeurActif extends Acteur {
    /**
     * Constructeur de la classe ActeurActif qui créer un acteur actif
     * lié à un graph donné avec un texte donné
     * @param p_graph Le graphe sur lequel sera l'acteur actif
     * @param p_texte Le texte lié à l'acteur actif
     */
    public ActeurActif(mxGraph p_graph, Diagramme p_diagramme, String p_texte){
        super(p_graph, p_diagramme, p_texte, new Dimension(60,85));
    }

    /**
     * Crée la représentation de l'acteur actif
     */
    @Override
    public final void creer(){
        mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();

        nouveauStyle.put(mxConstants.STYLE_SHAPE,
                  mxConstants.SHAPE_ACTOR);
        nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
        nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, "#774400");
        feuilleStyles.putCellStyle("ACTEUR_ACTIF", nouveauStyle);
		
        super.setCellule((mxCell) super.getGraph().insertVertex(
            null, null, super.getTexte(), 30, 30,
			super.getDimension().getWidth(), super.getDimension().getHeight(),
			"ACTEUR_ACTIF"));
        super.setVisible(false);
        
        super.getDiagramme().getElementsGraphiques().add(this);
    }

}

