import evenements.EvenementCarre;
import evenements.EvenementBtnFleche;
import evenements.EvenementBtnCarre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/**
 * Classe concernant tout ce qui est l'affichage de la fenetre
 *
 * @author satenske
 */
public class Fenetre extends JFrame{
    private Panneau panneauPrincipal = new Panneau();

    private JMenuBar menuBar = new JMenuBar();
    private JMenu fichier = new JMenu("Fichier");
    private JMenu inserer= new JMenu("Insérer");
    private JMenuItem enregistrer = new JMenuItem("Enregistrer");
    private JMenuItem ouvrir = new JMenuItem("Ouvrir");
    private JMenuItem exporter = new JMenuItem("Exporter");
    private JMenuItem quitter = new JMenuItem("Quitter");
    private JMenuItem carre = new JMenuItem("Carré");

	private JToolBar toolBar = new JToolBar();
	private Color fondBouton = Color.WHITE;

	private JButton btnCarre = new JButton(new ImageIcon("img/carre.jpg"));
	private JButton btnFleche = new JButton("f");

	private EvenementBtnCarre listenerBtnCarre = new EvenementBtnCarre(panneauPrincipal.getGraph(), this);
	private EvenementCarre listenerCarre = new EvenementCarre(panneauPrincipal.getGraph(), this);
	private EvenementBtnFleche listenerBtnFleche = new EvenementBtnFleche(panneauPrincipal.getGraph(), this, listenerCarre);
 //   private ActionListener listenerQuitter = new ActionListener();

    /**
     * Constructeur de la fenetre.
     */
    public Fenetre(){
        this.setTitle("Démonstrateur de la bibliothèque UML");
        this.setSize(600, 650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
    }

    /**
     * Permet d'afficher la fenetre, avec tous les boutons et le graph
     */
    public void afficherFenetre(){
         /* on verra plus tard comment serons les boutons, et ou on les feras.
         */
		fichier.add(enregistrer);
		fichier.add(ouvrir);
		fichier.add(exporter);
		fichier.add(quitter);

		inserer.add(carre);


		panneauPrincipal.add(menuBar);
		this.toolBar.add(btnCarre);
		this.toolBar.add(btnFleche);
		this.toolBar.setFloatable(false);
		this.toolBar.setPreferredSize(new Dimension(600, 30));

		panneauPrincipal.add(toolBar);
		menuBar.add(fichier);
		menuBar.add(inserer);

		btnCarre.addMouseListener(listenerBtnCarre);
		btnFleche.addMouseListener(listenerBtnFleche);

		panneauPrincipal.add(panneauPrincipal.getPanneauGraph(), BorderLayout.SOUTH);
		this.setJMenuBar(menuBar);
		this.setContentPane(this.panneauPrincipal);
		this.setVisible(true);

    }
    /**
     * Méthode principale
     * @param args
     */
    public static void main(String[] args) {
       Fenetre fenetre = new Fenetre();
       fenetre.afficherFenetre();
     }
}