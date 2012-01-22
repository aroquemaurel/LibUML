package eltGraphique.eltModelisation;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import util.Constantes;
import util.Position;

/**
 * Modélise un cas d'utilisation par une ellipse et un texte
 *
 * @author Antoine
 */
public class CasUtilisation extends ElementModelisation {
    /**
    * Créer le style d'un Cas d'utilisation
    */
    private void creerStyleCasUtilisation(){
            mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
            Map<String, Object> nouveauStyle = new HashMap<String, Object>();

            nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
            nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
            nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
            nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_BORDURE);
            nouveauStyle.put(mxConstants.STYLE_FOLDABLE, mxConstants.NONE);
            feuilleStyles.putCellStyle("USECASE", nouveauStyle);
    }

    /**
    * Constructeur de la classe CasUtilisation
    * @param p_graph Le graphe auquel sera ajouté le cas d'utilisation
    * @param p_texte Le texte qui sera associé au cas d'utilisation
    */
    public CasUtilisation(mxGraph p_graph, Diagramme p_diagramme, String p_texte, Position p_position) {
		super(p_graph, p_diagramme, p_texte, new Dimension(150,75), p_position);
    }
    
    /**
    * Crée la représentation graphique du cas d'utilisation
    */
    @Override
    public final void creer(){
        this.creerStyleCasUtilisation();

        super.setCellule((mxCell) super.getGraph().insertVertex(
                super.getParent(), null, super.getTexte(), super.getPosition().getAbscisse(), 
                        super.getPosition().getOrdonnee(),
                super.getDimension().getWidth(), super.getDimension().getHeight(),
                "USECASE"));

        super.getDiagramme().getElementsGraphiques().add(this);
    }
}
