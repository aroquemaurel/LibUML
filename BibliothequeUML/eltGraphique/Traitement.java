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
import util.Constantes;

/**
 * Modélise un traitement par un rectangle vertical et un élément déclencheur
 */
public class Traitement extends ElementModelisation {
	/**
	 * L'élément qui déclenche le traitement (appel de méthode, etc.)
	 */
	private Lien evenementDeclencheur;
	private boolean debutSequence;
	private static final double BAS_EVENEDECLENCHEUR = 13.37 ;
	private static final double HAUT_EVENEDECLENCHEUR = -BAS_EVENEDECLENCHEUR;
	private static final double GAUCHE_EVENEDECLENCHEUR = 10;
	private static final double DROITE_EVENEDECLENCHEUR = 35;

	/**
	 * Créer le style pour le rectangle du traitement
	 */
	private void creerStyleTraitement() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();
        nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
        nouveauStyle.put(mxConstants.STYLE_IMAGE_BACKGROUND, "images/btn_classe.jpg");
        nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
        nouveauStyle.put(mxConstants.STYLE_FOLDABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_BORDURE);
        nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
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
        nouveauStyle.put(mxConstants.STYLE_FILLCOLOR, Constantes.COULEUR_FOND);
        nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
        nouveauStyle.put(mxConstants.STYLE_MOVABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_RESIZABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_WEST);
        nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
        nouveauStyle.put(mxConstants.STYLE_DELETABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT);
        feuilleStyles.putCellStyle("FLECHE_EVENEMENT_DECLENCHEUR", nouveauStyle);
	}
	
	/**
	 * Constructeur de la classe traitement
	 * @param p_graph Le graphe auquel sera ajouter le traitement
	 * @param p_texte Le texte qui sera associé au traitement
	 */
    public Traitement(mxGraph p_graph, Diagramme p_diagramme, String p_texte, Lien p_evenementDeclencheur, boolean p_debutSequence){
        super(p_graph, p_diagramme, p_texte, new Dimension(20,80));
        this.evenementDeclencheur = p_evenementDeclencheur;
		this.debutSequence = p_debutSequence;
    }

	/**
	 * Crée la représentation graphique d'un traitement
	 */
    @Override
    public final void creer() {
		super.getGraph().getModel().beginUpdate();
		mxCell celluleFlecheEvenementDeclencheur;
		List<mxPoint> listePoint = new ArrayList<mxPoint>();

		this.creerStyleTraitement();
		this.creerStyleFlecheTraitement();

        super.setCellule((mxCell) super.getGraph().insertVertex(
            super.getParent(), null, null, 30, 30,
			super.getDimension().getWidth(), super.getDimension().getHeight(), "TRAITEMENT"));

		celluleFlecheEvenementDeclencheur = (mxCell) super.getGraph().insertEdge(super.getCellule(), null,
				this.getTexte(), null, null, "FLECHE_EVENEMENT_DECLENCHEUR");

		/* On créé une liste de point par laquelle passera la flèche evenemnt déclencheur */
		listePoint.add(new mxPoint(GAUCHE_EVENEDECLENCHEUR,HAUT_EVENEDECLENCHEUR));
		listePoint.add(new mxPoint(DROITE_EVENEDECLENCHEUR,HAUT_EVENEDECLENCHEUR));
		listePoint.add(new mxPoint(DROITE_EVENEDECLENCHEUR, BAS_EVENEDECLENCHEUR));
		celluleFlecheEvenementDeclencheur.getGeometry().setSourcePoint(
				new mxPoint(GAUCHE_EVENEDECLENCHEUR, 0));
		celluleFlecheEvenementDeclencheur.getGeometry().setTargetPoint(
				new mxPoint(super.getDimension().getWidth(), BAS_EVENEDECLENCHEUR));

		celluleFlecheEvenementDeclencheur.getGeometry().setPoints(listePoint);
		super.getDiagramme().getElementsGraphiques().add(this);
		super.getGraph().getModel().endUpdate();
    }

    public Lien getEvenementDeclencheur() {
        return evenementDeclencheur;
    }
	
	public boolean estDebutSequence() {
		return this.debutSequence;
	}

    public void setEvenementDeclencheur(Lien evenementDeclencheur) {
        this.evenementDeclencheur = evenementDeclencheur;
    }
	
	public void setDebutSequence(boolean p_boolean) {
		this.debutSequence = p_boolean;
		this.evenementDeclencheur.setVisible(p_boolean);
	}

}