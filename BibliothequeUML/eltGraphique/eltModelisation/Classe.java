package eltGraphique.eltModelisation;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import util.Constantes;
import util.Liste;
import util.Position;

/**
 * Modélise une classe par trois carrés contenant le titre de la classe, 
 * les attributs et les méthodes 
 *
 * @author Mathieu
 * @author Antoine
 */
public class Classe extends eltGraphique.eltModelisation.ElementModelisation {
    /**
	 * Classe abstraite ?
	 */
    private boolean abstraite;
    
    /**
    * Liste des méthodes de la classe
	*
    * @see Methode
	* @see util.Liste
    */
    private Liste<Methode> methodes;
    
    /**
    * Liste des attributs de la classe
	*
    * @see Attribut
	* @see util.Liste
    */
    private Liste<Attribut> attributs;
    
    /**
    * Classe constante ?
    */
    private boolean constante;
    
    /**
     * Cellule contenant les attributs 
     */
    private mxCell celluleAttributs;
    
    /**
     * Cellule contenant les méthodes 
     */
    private mxCell celluleMethodes;
    
    /**
     * Offset permettant de mettre à jour la classe avec une bonne hauteur
     */
    private double OFFSET_HAUTEUR_CLASSE = 10.0;
    
    /**
    * Creer le style d'une classe
    */
    private void creerStyleClasse(){
        mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();

        nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_SWIMLANE);
        nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
        nouveauStyle.put(mxConstants.STYLE_FOLDABLE, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
        nouveauStyle.put(mxConstants.STYLE_RESIZABLE, mxConstants.NONE);
        feuilleStyles.putCellStyle("CLASSE", nouveauStyle);
	}
    
    /**
    * Créer le style du contenu d'une classe (cadre méthodes, cadre attributs)
    */
    private void creerStyleContenuClasse(){
        mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();

        nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
        nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
        nouveauStyle.put(mxConstants.STYLE_FOLDABLE, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_FILLCOLOR, Constantes.COULEUR_FOND);
        nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_RESIZABLE, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_DELETABLE, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT);
        nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
        feuilleStyles.putCellStyle("CONTENUCLASSE", nouveauStyle);
    }

	/**
	 * Génère la chaine de caractère contenant toutes les méthodes
	 *
	 * @return La chaine de caractère
	 */
    private String genererChaineMethodes(){
       String retour = new String();

       for(int i=0; i < this.methodes.taille(); i++){
            retour += this.methodes.get(i).toString();
       }

       return retour;
    }

	/**
	 * Génère la chaine de caractère contenant tous les attributs
	 *
	 * @return La chaine de caractère
	 */
    private String genererChaineAttributs(){
       String retour = "";

       for(int i=0; i < this.attributs.taille(); i++) {
            retour += this.attributs.get(i).toString();
       }

       return retour;
    }

    /**
    * Constructeur d'un élément 'classe'
	*
    * @param p_graph Le graphe auquel sera ajouter la classe
    * @param p_texte Le texte associé à la classe (son nom)
    */
    public Classe(mxGraph p_graph, Diagramme p_diagramme, String p_texte, Position p_position){
        super(p_graph, p_diagramme, "\n"+p_texte+"\n ", new Dimension(125,150), p_position);

        this.attributs = new Liste<Attribut>();
        this.methodes = new Liste<Methode>();
        this.abstraite = false;
        this.constante = false;
        this.celluleAttributs = new mxCell();
        this.celluleMethodes = new mxCell();
    }

    /**
    * Ajoute la méthode passée en paramètre à la liste des méthodes
	*
    * @param p_nouvelleMethode La méthode qui sera ajoutée
    * @return La méthode ajoutée
    * @see Methode
    */
    public final Methode ajouterMethode(Methode p_nouvelleMethode) {
        this.methodes.ajouterElement(p_nouvelleMethode);
        this.celluleMethodes.setValue(this.genererChaineMethodes());
        this.mettreAJour();
        
        return(p_nouvelleMethode);
    }

    /**
    * Ajoute un attribut à la liste d'attributs de la classe
	*
    * @param p_nouvelAttribut Le nouvel attribut à ajouter à la classe
    * @return Le nouvel attribut ajouté
    * @see Attribut
    */
    public final Attribut ajouterAttribut(Attribut p_nouvelAttribut) {
        this.attributs.ajouterElement(p_nouvelAttribut);
        this.celluleAttributs.setValue(this.genererChaineAttributs());
        this.mettreAJour();
        
        return(p_nouvelAttribut);
    }
    
    /**
    * Met à jour la liste des éléments de la liste
    * @param p_elements La liste d'éléments graphiques à mettre à jour
    */    
    @Override
    public void mettreAJour(){
        super.mettreAJour();
        super.getCellule().getGeometry().setHeight(this.getDimension().getHeight()+OFFSET_HAUTEUR_CLASSE);
    }
    /**
     * Retourne vrai si la classe est constante, faux sinon.
	 *
     * @return Classe constante ?
     */
    public boolean estConstante() {
        return (this.constante);
    }

    /**
     * Retourne vrai si la classe est abstraite, faux sinon.
	 *
     * @return si la classe est abstraite ou non.
     */
    public boolean estAbstraite() {
        return (this.abstraite);
    }

    /**
     * Retourne la liste des attributs de la classe
	 *
     * @return Liste des attributs de la classe
	 * 
	 * @see util.Liste
     * @see Attribut
     */
    public Liste<Attribut> getAttributs() {
        return (this.attributs);
    }

    /**
     * Retourne la liste des méthodes de la classe
	 *
     * @return Liste des méthodes de la classe
	 * 
	 * @see util.Liste
     * @see Methode
     */
    public Liste<Methode> getMethodes() {
        return (this.methodes);
    }

    /**
     * Modifie la constance de la classe
	 *
     * @param p_constante Classe constante ?
     */
    public void setConstante(boolean p_constante) {
        this.constante = p_constante;
    }

    /**
     * Modifie l'abstraction de la classe
	 *
     * @param p_abstraite Classe abstraite ?
     */
    public void setAbstraite(boolean p_abstraite) {
        this.abstraite = p_abstraite;
    }

    /**
     * Remplace la liste des attributs de la classe
	 *
     * @param p_attributs La nouvelle liste d'attributs
     * @see Attribut
     */
    public void setAttributs(Liste<Attribut> p_attributs) {
        this.attributs = p_attributs;
    }

    /**
     * Remplace la liste des méthodes de la classe
	 *
     * @param p_methodes La nouvelle liste de méthodes
     * @see Methode
     */
    public void setMethodes(Liste<Methode> p_methodes) {
        this.methodes = p_methodes;
    }

    /**
     * Crée la représentation graphique de la classe
     */
    @Override
    public final void creer() {
        this.creerStyleClasse();
        this.creerStyleContenuClasse();

        super.setCellule((mxCell) super.getGraph().insertVertex( null, null, super.getTexte(), 
                super.getPosition().getAbscisse(), super.getPosition().getOrdonnee(),
                         super.getDimension().getWidth(), super.getDimension().getHeight(), "CLASSE"));

        this.celluleAttributs = (mxCell) super.getGraph().insertVertex( super.getCellule(), null,
                                this.genererChaineAttributs(), 0, 0, super.getDimension().getWidth(), 60,
                                "CONTENUCLASSE");

        this.celluleMethodes = (mxCell) super.getGraph().insertVertex( super.getCellule(), null,
                               this.genererChaineMethodes(), 0, 100, super.getDimension().getWidth(), 60,
                               "CONTENUCLASSE");

        this.celluleAttributs.setConnectable(false);
        this.celluleMethodes.setConnectable(false);

        super.getDiagramme().getElementsGraphiques().add(this);
    }

	public void genererInterface() {
		Interface inte = new Interface(super.getGraph(), super.getTexte(), 
			super.getDiagramme(), 
			new Position(this.getPosition().getAbscisse()+250, 
						 this.getPosition().getOrdonnee()+75));
		inte.creer();
		
		/* Lien avec la classe */
		Lien spe = new Lien(this, inte, super.getGraph(), super.getDiagramme(), TypeLien.SPECIALISATION);
		spe.creer();
		
        super.getDiagramme().getElementsGraphiques().add(spe);
	}
}

