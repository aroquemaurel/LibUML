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
 * 
 * @author Mathieu
 * @author Antoine
 */
public class Traitement extends ElementModelisation {
	/**
	 * L'élément qui déclenche le traitement (appel de méthode, etc.)
	 */
	private Lien evenementDeclencheur;
	
	/**
	 * Traitement de début de séquence ?
	 */
	private boolean debutSequence;
	
	/**
	 * Constante représentant la côte basse de l'élément déclencheur
	 */
	private static final double BAS_EVENEDECLENCHEUR = 13.37 ;
	
	/**
	 * Constante représentant la côte haute de l'élément déclencheur
	 */
	private final double HAUT_EVENEDECLENCHEUR = -BAS_EVENEDECLENCHEUR;
	
	/**
	 * Constante représentant la côte gauche de l'élément déclencheur
	 */
	private static final double GAUCHE_EVENEDECLENCHEUR = 10;
	
	/**
	 * Constante représentant la côte droite de l'élément déclencheur
	 */
	private static final double DROITE_EVENEDECLENCHEUR = 35;

        /**
         * Créé la flèche de début de séquence (flèche partant d'un traitement et revenant sur les même traitement)
         */
    private void creerFlecheDebutSequence() {
        this.evenementDeclencheur = new Lien(this, this, super.getGraph(), super.getDiagramme(), null);

        mxCell celluleFlecheEvenementDeclencheur;
        List<mxPoint> listePoint = new ArrayList<mxPoint>();

        this.creerStyleFlecheTraitement();

        celluleFlecheEvenementDeclencheur = (mxCell) super.getGraph().insertEdge(super.getCellule(), null,
                        this.getTexte(), null, null, "FLECHE_EVENEMENT_DECLENCHEUR");

        /* On créé une liste de point par laquelle passera la flèche correspondant à l'événement déclencheur */
        listePoint.add(new mxPoint(GAUCHE_EVENEDECLENCHEUR,HAUT_EVENEDECLENCHEUR));
        listePoint.add(new mxPoint(DROITE_EVENEDECLENCHEUR,HAUT_EVENEDECLENCHEUR));
        listePoint.add(new mxPoint(DROITE_EVENEDECLENCHEUR, BAS_EVENEDECLENCHEUR));
        celluleFlecheEvenementDeclencheur.getGeometry().setSourcePoint(
                        new mxPoint(GAUCHE_EVENEDECLENCHEUR, 0));
        celluleFlecheEvenementDeclencheur.getGeometry().setTargetPoint(
                        new mxPoint(super.getDimension().getWidth(), BAS_EVENEDECLENCHEUR));

        celluleFlecheEvenementDeclencheur.getGeometry().setPoints(listePoint);
        celluleFlecheEvenementDeclencheur.setVisible(this.debutSequence);
        this.evenementDeclencheur.setCellule(celluleFlecheEvenementDeclencheur);
    }
    
        /**
	 * Créer le style pour le rectangle du traitement
	 */
	private void creerStyleTraitement() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();
        nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
        nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
        nouveauStyle.put(mxConstants.STYLE_FOLDABLE, mxConstants.NONE);
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
                nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
                nouveauStyle.put(mxConstants.STYLE_FILLCOLOR, Constantes.COULEUR_FOND);
                nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
                nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
                nouveauStyle.put(mxConstants.STYLE_RESIZABLE, mxConstants.NONE);
                nouveauStyle.put(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_WEST);
                nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
                nouveauStyle.put(mxConstants.STYLE_DELETABLE, mxConstants.NONE);
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
            this.debutSequence = p_debutSequence;
            this.evenementDeclencheur = p_evenementDeclencheur;
        }

	/**
	 * Crée la représentation graphique d'un traitement
	 */
        @Override
        public final void creer() {
		super.getGraph().getModel().beginUpdate();
                this.creerStyleTraitement();

                super.setCellule((mxCell) super.getGraph().insertVertex(
                        super.getParent(), null, null, 30, 30,
			super.getDimension().getWidth(), super.getDimension().getHeight(), "TRAITEMENT"));

		if (this.evenementDeclencheur == null) {
                    this.creerFlecheDebutSequence(); 

		}
		super.getDiagramme().getElementsGraphiques().add(this);
		super.getGraph().getModel().endUpdate();
        }
	
	/**
	 * Récupère l'évenement déclencheur du traitement
	 * @return L'élément déclencheur
	 * 
	 * @see Lien
	 */
        public Lien getEvenementDeclencheur() {
            return(this.evenementDeclencheur);
        }
	
	/**
	 * Retourn vrai si le traitement est le premier de la séquence, faux sinon
	 * @return Debut de séquence ?
	 */
	public boolean estDebutSequence() {
		return(this.debutSequence);
	}

	/**
	 * Remplace l'élément déclencheur par celui passé en paramètre
	 * @param evenementDeclencheur Le nouvel élément déclencheur
	 * 
	 * @see Lien
	 */
        public void setEvenementDeclencheur(Lien evenementDeclencheur) {
            this.evenementDeclencheur = evenementDeclencheur;
        }
	
	/**
	 * Modifie le fait que le traitement soit en début de séquence (ou non).
	 * Cela a pour but d'afficher (ou non) l'élément déclencheur représenté par une flèche qui reviens sur le 
         * traitement
	 * 
	 * @param p_boolean Debut de séquence ?
	 */
	public void setDebutSequence(boolean p_boolean) {
		this.debutSequence = p_boolean;
		this.evenementDeclencheur.getCellule().setVisible(p_boolean);
	}

}