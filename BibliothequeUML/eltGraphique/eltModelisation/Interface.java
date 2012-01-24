package eltGraphique.eltModelisation;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import util.Constantes;
import util.Position;

/**
 * Modélise une interface par un petit cercle et un texte
 */
public class Interface extends ElementModelisation {
	private final double OFFSET_TEXTE_INTERFACE_X=30.;
	private final double OFFSET_TEXTE_INTERFACE_Y=-35.;
	
    /**
	 * Crée le style graphique d'une interface
	 */
	private void creerStyleInterface() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();
        nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        nouveauStyle.put(mxConstants.STYLE_AUTOSIZE, 1);
        nouveauStyle.put(mxConstants.STYLE_FOLDABLE, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_BORDURE);
        nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
        feuilleStyles.putCellStyle("INTERFACE", nouveauStyle);
	}

    /**
     * Constructeur de la classe traitement
     * @param p_graph Le graphe auquel sera ajouter l'interface
     * @param p_texte Le texte qui sera associé à l'interface
     */
    public Interface(mxGraph p_graph, String p_nomClasse, Diagramme p_diagramme, Position p_position){
        super(p_graph, p_diagramme, "Int_"+p_nomClasse, new Dimension(42, 42), p_position);
    }

    /**
     * Crée la représentation graphique d'une interface
     */
    @Override
    public final void creer() {
		super.getGraph().getModel().beginUpdate();
		this.creerStyleInterface();
		/* Rond de l'interface */
		super.setCellule((mxCell) super.getGraph().insertVertex(
				super.getParent(), null, super.getTexte(),
				super.getPosition().getAbscisse(), 
				super.getPosition().getOrdonnee(),
				super.getDimension().getWidth(),
				super.getDimension().getHeight(), "INTERFACE"));
		
        //TODO création des interfaces
        super.getDiagramme().getElementsGraphiques().add(this);
		
		super.getCellule().getGeometry().setOffset(new mxPoint(OFFSET_TEXTE_INTERFACE_X, OFFSET_TEXTE_INTERFACE_Y));
		super.getGraph().getModel().endUpdate();
    }
}
