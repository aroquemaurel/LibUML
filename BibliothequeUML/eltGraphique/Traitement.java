package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import eltGraphique.ligne.Lien;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

/**
 * Modélise un traitement par un rectangle vertical et un élément déclencheur
 */
public class Traitement extends ElementModelisation {
	/**
	 * L'élément qui déclenche le traitement (appel de méthode, etc.)
	 */
	private Lien evenementDeclencheur;

	/**
	 * Constructeur de la classe traitement
	 * @param p_graph Le graphe auquel sera ajouter le traitement
	 * @param p_texte Le texte qui sera associé au traitement
	 */
    public Traitement(mxGraph p_graph, Diagramme p_diagramme, String p_texte,
                      Lien p_evenementDeclencheur){
        super(p_graph, p_diagramme, p_texte, new Dimension(20,80));
        this.evenementDeclencheur = p_evenementDeclencheur;
    }

	/*
	 * TODO Ajouter l'acteur associé  ca peut être intéressant ??
	 */

	/**
	 * Crée la représentation graphique d'un traitement
	 */
    @Override
    public final void creer() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();

        nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
        nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
        nouveauStyle.put(mxConstants.STYLE_FOLDABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, "#774400");
        feuilleStyles.putCellStyle("TRAITEMENT", nouveauStyle);

        nouveauStyle = new HashMap<String, Object>();
        nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
        nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
        nouveauStyle.put(mxConstants.STYLE_FILLCOLOR, "#e4e5ef");
        nouveauStyle.put(mxConstants.STYLE_MOVABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_RESIZABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_DELETABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT);
        feuilleStyles.putCellStyle("FLECHE_TRAITEMENT", nouveauStyle);
		//TODO Bonne position de la fêche
		//TODO Bonne position du texte
        super.setCellule((mxCell) super.getGraph().insertVertex(
            super.getParent(), null, super.getTexte(), 30, 30,
			super.getDimension().getWidth(),
                        super.getDimension().getHeight()));
        super.setVisible(false);

     super.setCellule((mxCell) super.getGraph().insertEdge(
            super.getGraph().getDefaultParent(), null, null,
            super.getParent(), super.getParent(),
            "FLECHE_TRAITEMENT"));
        super.getDiagramme().getElementsGraphiques().add(this);

    }

    public Lien getEvenementDeclencheur() {
        return evenementDeclencheur;
    }

    public void setEvenementDeclencheur(Lien evenementDeclencheur) {
        this.evenementDeclencheur = evenementDeclencheur;
    }
}
