package eltGraphique.ligne;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import eltGraphique.ElementGraphique;
import eltGraphique.eltModelisation.ElementModelisation;
import java.util.HashMap;
import java.util.Map;
import util.Constantes;

/**
 * Classe servant à la modélistaion des liens dans les différents diagrammes
 * Les différents types de liens sont gérés grâce à un attribut de type TypeLien
 *
 * @see TypeLien
 * 
 * @author Antoine
 */
public class Lien extends ElementGraphique {
    /**
     * Elément à l'origine du lien
     * @see ElementModelisation
     */
    private ElementModelisation source;
    /**
     * Elément à l'extrémité du lien
     * @see ElementModelisation
     */
    private ElementModelisation destination;
    /**
     * Le type de la flèche
	 * 
	 * @see TypeLien
     */
    private TypeLien typeLien;

	/* 
	 * Construit le style d'une composition
	 */ 
	private void creerStyleComposition() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
		nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
		nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_DIAMOND);
		nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
		nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
		nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
		feuilleStyles.putCellStyle("COMPOSITION", nouveauStyle);
	}
	
	/* 
	 * Construit le style d'une dépendance 
	 */ 
	private void creerStyleDependance() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
		nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
		nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_OPEN);
		nouveauStyle.put(mxConstants.STYLE_ENDSIZE, Constantes.TAILLE_FLECHE);
		nouveauStyle.put(mxConstants.STYLE_DASHED, true);
		nouveauStyle.put(mxConstants.STYLE_DASH_PATTERN, Constantes.ESPACE_TIRETS);
		nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
		nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
		nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
		feuilleStyles.putCellStyle("DEPENDANCE", nouveauStyle);
	}

	/* 
	 * Construit le style d'une d'agrégation
	 */ 
	private void creerStyleAgregation() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
		nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
		nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_DIAMOND);
		nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
		nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
		nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
		nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
		//TODO couleur de fond bout des flêches ?!
                feuilleStyles.putCellStyle("AGREGATION", nouveauStyle);
	}

	/** 
	 * Construit le style d'une flèche classique
	 */ 
	private void creerStyleFleche() {
            mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
            Map<String, Object> nouveauStyle = new HashMap<String, Object>();
            nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
            nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
            nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
            nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
            nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
            feuilleStyles.putCellStyle("FLECHE", nouveauStyle);
	}
        
        /**
         * Construit le style d'une flèche en pointillée
         */
        private void creerStyleFlechePointille() {
            mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
            Map<String, Object> nouveauStyle = new HashMap<String, Object>();
            nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
            nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
            nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
            nouveauStyle.put(mxConstants.STYLE_DASHED, true);
            nouveauStyle.put(mxConstants.STYLE_DASH_PATTERN, Constantes.ESPACE_TIRETS);
            nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
            nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
            feuilleStyles.putCellStyle("FLECHE_POINTILLEE", nouveauStyle);
        }
	/**
	 * Construit le style d'une association
	 */ 
	private void creerStyleAssociation() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
		nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ORTHOGONAL);
		nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_SPACING);
		nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
		nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
		nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
		feuilleStyles.putCellStyle("ASSOCIATION", nouveauStyle);
	}

	/**
	 * Construit le style d'une spécialisation 
	 */ 
	private void creerStyleSpecialisation() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
            nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
            nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
            nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
			nouveauStyle.put(mxConstants.STYLE_ENDSIZE, Constantes.TAILLE_FLECHE+10);
            nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
            nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
		feuilleStyles.putCellStyle("SPECIALISATION", nouveauStyle);
	}

	/**
	 * Construit le style d'un message synchrone
	 */ 
	private void creerStyleMessageSynchrone() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
		nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
		nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_OPEN);
		nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
		nouveauStyle.put(mxConstants.STYLE_ENDSIZE, Constantes.TAILLE_FLECHE);
		nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
		nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
		feuilleStyles.putCellStyle("MESSAGE_SYNCHRONE", nouveauStyle);
	}


	/**
	 * Constructeur de la classe Lien modelisant tout type de lien dans un graphe
	 * 
	 * @param p_source Element à l'origine de la flèche
	 * @param p_destination Elemet à l'extrémité de la flèche
	 * @param p_graph Graphe auquel est associé la flèche
	 * @param p_typeLien Type de la flèche
	 *
	 * @see ElementModelisation
	 * @see TypeLien
	 */
    public Lien(ElementModelisation p_source, ElementModelisation p_destination, mxGraph p_graph,
			Diagramme p_diagramme, TypeLien p_typeLien){
        super(p_graph, p_diagramme);
        this.source = p_source;
        this.destination = p_destination;
        this.typeLien = p_typeLien;
    }
    
	/**
	 * Crée le style de flèche adéquat, en fonction de l'attribut typeLien
	 * 
	 * @see eltGraphique.ligne.TypeLien
	 */
    protected void creerLeStyleDeLien(){
        switch(this.typeLien){
            case SPECIALISATION:
                this.creerStyleSpecialisation();
                break;
            case ASSOCIATION:
                this.creerStyleAssociation();
                break;
            case FLECHE:
                this.creerStyleFleche();
                break;
            case FLECHE_POINTILLEE:
                this.creerStyleFlechePointille();
                break;                    
            case AGREGATION:
                this.creerStyleAgregation();
                break;
            case COMPOSITION:
                this.creerStyleComposition();
                break;
            case DEPENDANCE:
                this.creerStyleDependance();
                break;
            case MESSAGE_SYNCHRONE:
                this.creerStyleMessageSynchrone();
                break;
            default:
            throw new UnsupportedOperationException("Type de flèche inconnu");
        }   
    }
    
	/**
	 * Récupère l'élément à l'extrémité de la flèche
	 *
	 * @return L'élément à l'extrémité de la flèche
	 */
	public ElementModelisation getDestination() {
		return (this.destination);
	}

	/**
	 * Récupère l'élément à l'origine de la flèche
	 *
	 * @return L'élément à l'origine de la flèche
	 */
	@Override
	public ElementModelisation getSource() {
		return (this.source);
	}

	/**
	 * Récupère le type de lien de la flèche
	 *
	 * @return Le type de lien
	 */
	public TypeLien getTypeLien(){
		return (this.typeLien);
	}
        
	/**
	 * Modifie l'élément à l'extrémité de la flèche
	 *
	 * @param p_destination Le nouvel élément à l'éxtrémité de la flèche
	 */
	public void setExtremite(ElementModelisation p_destination) {
		this.destination = p_destination;
	}

	/**
	 * Modifie l'élément à l'origine de la flèche
	 *
	 * @param p_source Le nouvelle élément à l'origine de la flèche
	 */
	public void setOrigine(ElementModelisation p_source) {
		this.source = p_source;
	}

	/**
	 * Modifie le type de la flèche en fonction du type passé en paramètre
	 *
	 * @param p_typeLien Le nouveau type de la flèche
	 */
	public void setTypeFleche(TypeLien p_typeLien) {
		this.typeLien = p_typeLien;
		super.getCellule().setStyle(p_typeLien.toString());
	}

	/**
	 * Crée le style et la représentation de la flèche en fonction
	 * des attributs de la classe.
	 */
	@Override
    public void creer(){
       this.creerLeStyleDeLien();

        
        super.setCellule((mxCell) super.getGraph().insertEdge(
                super.getGraph().getDefaultParent(), null, null,
                this.getSource().getCellule(), this.getDestination().getCellule(),
                this.typeLien.toString()));

        super.setConnectable(false);
        super.getDiagramme().getElementsGraphiques().add(this);
        
        this.source.getLiens().ajouterElement(this);
        this.destination.getLiens().ajouterElement(this);
    }


}
