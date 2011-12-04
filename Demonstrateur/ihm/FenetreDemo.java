package ihm;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
/**
 * Classe concernant tout ce qui est l'affichage de la fenetre
 *
 *
 * @author satenske
 */
public class FenetreDemo extends JFrame {
//    private PanneauGraph panneauPrincipal = new PanneauGraph();
	private mxGraph panneauPrincipal = new mxGraph();
	private Object parent = this.panneauPrincipal.getDefaultParent();
	private mxConstants test;
	/* Pour le menu */
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fichier = new JMenu("Fichier");
    private JMenu inserer= new JMenu("Insérer");
    private JMenuItem enregistrer = new JMenuItem("Enregistrer");
    private JMenuItem ouvrir = new JMenuItem("Ouvrir");
    private JMenuItem exporter = new JMenuItem("Exporter");
    private JMenuItem quitter = new JMenuItem("Quitter");
    private JMenuItem carre = new JMenuItem("Carré");

	/* Pour le menu contextuel */
	private JPopupMenu menuContextuel = new JPopupMenu();
	private JMenuItem copier = new JMenuItem("Copier");
	private JMenuItem coller = new JMenuItem("Coller");
	private JMenuItem couper = new JMenuItem("Couper");
	private JMenuItem supprimer = new JMenuItem("Supprimer");

	private JButton btnCarre = new JButton(new ImageIcon("img/carre.jpg"));
	private JButton btnFleche = new JButton("f");

	private void ajouterListenerEvenements(){
	/*	EvenementCarre listenerCarre =
		new EvenementCarre(this.panneauPrincipal.getGraph(), this);
		EvenementBtnCarre listenerBtnCarre =
		new EvenementBtnCarre(this.panneauPrincipal.getGraph(),
				      this);
		EvenementBtnFleche listenerBtnFleche =
		new EvenementBtnFleche(this.panneauPrincipal.getGraph(),
				       this, listenerCarre);

		this.btnCarre.addMouseListener(listenerBtnCarre);
		this.btnFleche.addMouseListener(listenerBtnFleche);
		this.panneauPrincipal.getGraph().
		    addMouseListener(listenerMenuCont);*/
	}

	private void ajouterObjetsGraphiques(){
		JToolBar toolBar = new JToolBar();
		this.fichier.add(this.enregistrer);
		this.fichier.add(this.ouvrir);
		this.fichier.add(this.exporter);
		this.fichier.add(this.quitter);
		this.inserer.add(this.carre);

//		this.panneauPrincipal.add(this.menuBar);
		toolBar.add(this.btnCarre);
		toolBar.add(this.btnFleche);
		toolBar.setFloatable(false);
		toolBar.setPreferredSize(new Dimension(600, 30));

//		this.panneauPrincipal.add(toolBar);

		this.menuBar.add(this.fichier);
		this.menuBar.add(this.inserer);
	}
	
	private void creerLesStyle() {
		mxStylesheet stylesheet =
		    this.panneauPrincipal.getStylesheet();
		Hashtable<String, Object> style =
		    new Hashtable<String, Object>();
		/* Ateur */
		style.put(mxConstants.STYLE_SHAPE,
			  mxConstants.SHAPE_ACTOR);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		stylesheet.putCellStyle("ACTEUR", style);
		/* UseCase */
		style = null;
		style = new Hashtable<String, Object>();
		style.put(mxConstants.STYLE_SHAPE,
			  mxConstants.SHAPE_ELLIPSE);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		stylesheet.putCellStyle("USECASE", style);
	}
	
    /**
     * Constructeur de la fenetre.
     */
    public FenetreDemo(){
	super("Démonstrateur de la bibliothèque UML");
	this.creerLesStyle();
	
	/* Création des styles */
	
        this.setSize(600, 650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(new BorderLayout());
		
	this.panneauPrincipal.getModel().beginUpdate();
	panneauPrincipal.insertVertex(parent, null,
					  "Acteur", 20, 20,
					  75, 100, "ACTEUR");
	panneauPrincipal.insertVertex(parent, null,
					  "UseCase", 30, 30,
					  150, 75, "USECASE");
	panneauPrincipal.insertVertex(parent, null,
					  "Morceau de classe", 40, 40,
					  120, 30);
	this.panneauPrincipal.getModel().endUpdate();
    }

	public void creerMenuContextuel(){
		this.menuContextuel.add(this.couper);
		this.menuContextuel.add(this.copier);
		this.menuContextuel.add(this.coller);
		this.menuContextuel.add(this.supprimer);
	}
	public mxGraph getPanneauPrincipal(){
		return this.panneauPrincipal;
	}
	public JPopupMenu getMenuContextuel(){
		return this.menuContextuel;
	}

    /**
     * Permet d'afficher la fenetre, avec tous les boutons et le graph
     */
    public void afficherFenetre(){
		this.ajouterObjetsGraphiques();
		this.ajouterListenerEvenements();
		this.setResizable(false);
/*		this.panneauPrincipal.add(this.panneauPrincipal.
							getPanneauGraph(),
					  BorderLayout.SOUTH);*/
		this.setJMenuBar(this.menuBar);
		mxGraphComponent graphComponent =
		    new mxGraphComponent(this.panneauPrincipal);
		this.setContentPane(graphComponent);
		this.setVisible(true);

    }
    /**
     * Méthode principale
     * @param args
     */
    public static void main(String[] args) {
       FenetreDemo fenetre = new FenetreDemo();
       fenetre.afficherFenetre();
    }
}
