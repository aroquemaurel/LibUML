package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import eltGraphique.ligne.Lien;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	 * Créer le style pour le rectangle du traitement
	 */
	private void creerStyleTraitement() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();
        nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
        nouveauStyle.put(mxConstants.STYLE_IMAGE_BACKGROUND, "images/btn_classe.jpg");
        nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
        nouveauStyle.put(mxConstants.STYLE_FOLDABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, "#774400");
        feuilleStyles.putCellStyle("TRAITEMENT", nouveauStyle);
	}

	/**
	 * Creer le style pour la fleche de l'événement déclencheur du traitement
	 */
	private void creerStyleFlecheTraitement(){
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();

        nouveauStyle = new HashMap<String, Object>();
		nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
        nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
        nouveauStyle.put(mxConstants.STYLE_FILLCOLOR, "#e4e5ef");
        nouveauStyle.put(mxConstants.STYLE_MOVABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_RESIZABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_WEST);
        nouveauStyle.put(mxConstants.STYLE_DELETABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT);
        feuilleStyles.putCellStyle("FLECHE_EVENEMENT_DECLENCHEUR_TRAITEMENT", nouveauStyle);

	}

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
		super.getGraph().getModel().beginUpdate();
		mxCell cellule;
		List<mxPoint> listePoint = new ArrayList<mxPoint>();

		this.creerStyleTraitement();
		this.creerStyleFlecheTraitement();
		//TODO Bonne position du texte
        super.setCellule((mxCell) super.getGraph().insertVertex(
            super.getParent(), null, super.getTexte(), 30, 30,
			super.getDimension().getWidth(), super.getDimension().getHeight(), "TRAITEMENT"));

        super.setVisible(false);

		cellule = (mxCell) super.getGraph().insertEdge(
								super.getCellule(), null, "", null, null,
								"FLECHE_EVENEMENT_DECLENCHEUR_TRAITEMENT");

		listePoint.add(new mxPoint(10.,-13.37));
		listePoint.add(new mxPoint(35.,-13.37));
		listePoint.add(new mxPoint(35., 13.37));
		cellule.getGeometry().setPoints(listePoint);
		cellule.getGeometry().setSourcePoint(new mxPoint(10.,0.));
		cellule.getGeometry().setTargetPoint(new mxPoint(20.,13.37));
		super.getDiagramme().getElementsGraphiques().add(this);

		super.getGraph().getModel().endUpdate();
    }

    public Lien getEvenementDeclencheur() {
        return evenementDeclencheur;
    }

    public void setEvenementDeclencheur(Lien evenementDeclencheur) {
        this.evenementDeclencheur = evenementDeclencheur;
    }
}