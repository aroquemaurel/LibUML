import evenements.EvenementCarre;
import evenements.btn.EvenementBtnFleche;
import evenements.btn.EvenementBtnCarre;

import evenements.menu.EvenementMenuCarre;
import evenements.menu.EvenementMenuEnregistrer;
import evenements.menu.EvenementMenuExporter;
import evenements.menu.EvenementMenuOuvrir;
import evenements.menu.EvenementMenuQuitter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
/** TODO : Possibilité de suppresion des éléments */
/**
 * Classe concernant tout ce qui est l'affichage de la fenetre
 *
 *
 * @author satenske
 */
public class Fenetre extends JFrame{
    private Panneau panneauPrincipal = new Panneau();

    private JMenuBar m_menuBar = new JMenuBar();
    private JMenu m_fichier = new JMenu("Fichier");
    private JMenu m_inserer= new JMenu("Insérer");
    private JMenuItem m_enregistrer = new JMenuItem("Enregistrer");
    private JMenuItem m_ouvrir = new JMenuItem("Ouvrir");
    private JMenuItem m_exporter = new JMenuItem("Exporter");
    private JMenuItem m_quitter = new JMenuItem("Quitter");
    private JMenuItem m_carre = new JMenuItem("Carré");

	private JToolBar m_toolBar = new JToolBar();

	private JButton m_btnCarre = new JButton(new ImageIcon("img/carre.jpg"));
	private JButton m_btnFleche = new JButton("f");

	private void ajouterListenerEvenements(){
		EvenementCarre listenerCarre = new EvenementCarre(panneauPrincipal.getGraph(), this);
		EvenementBtnCarre listenerBtnCarre = new EvenementBtnCarre(panneauPrincipal.getGraph(), this);
		EvenementBtnFleche listenerBtnFleche = new EvenementBtnFleche(panneauPrincipal.getGraph(), this, listenerCarre);
		EvenementMenuEnregistrer listenerMenuEnregistrer = new EvenementMenuEnregistrer(panneauPrincipal.getGraph());
		EvenementMenuOuvrir listenerMenuOuvrir = new EvenementMenuOuvrir(panneauPrincipal.getGraph());
		EvenementMenuExporter listenerMenuExporter = new EvenementMenuExporter(panneauPrincipal.getGraph());
		EvenementMenuQuitter listenerMenuQuitter = new EvenementMenuQuitter(panneauPrincipal.getGraph());
		EvenementMenuCarre listenerMenuCarre = new EvenementMenuCarre(panneauPrincipal.getGraph());

		m_btnCarre.addMouseListener(listenerBtnCarre);
		m_btnFleche.addMouseListener(listenerBtnFleche);
		m_quitter.addActionListener(listenerMenuQuitter);
		m_exporter.addActionListener(listenerMenuExporter);
		m_enregistrer.addActionListener(listenerMenuEnregistrer);
		m_carre.addActionListener(listenerMenuCarre);
		m_ouvrir.addActionListener(listenerMenuOuvrir);
	}

	private void ajouterObjetsGraphiques(){
		m_fichier.add(m_enregistrer);
		m_fichier.add(m_ouvrir);
		m_fichier.add(m_exporter);
		m_fichier.add(m_quitter);
		m_inserer.add(m_carre);

		panneauPrincipal.add(m_menuBar);
		m_toolBar.add(m_btnCarre);
		m_toolBar.add(m_btnFleche);
		m_toolBar.add(new JButton("c"));
		m_toolBar.setFloatable(false);
		m_toolBar.setPreferredSize(new Dimension(600, 30));

		panneauPrincipal.add(m_toolBar);

		m_menuBar.add(m_fichier);
		m_menuBar.add(m_inserer);
	}
    /**
     * Constructeur de la fenetre.
     */
    public Fenetre(){
        this.setTitle("Démonstrateur de la bibliothèque UML");
        this.setSize(600, 650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Impératif !!
		this.setLayout(new BorderLayout());
    }

    /**
     * Permet d'afficher la fenetre, avec tous les boutons et le graph
     */
    public void afficherFenetre(){
		this.ajouterObjetsGraphiques();
		this.ajouterListenerEvenements();
		panneauPrincipal.add(panneauPrincipal.getPanneauGraph(), BorderLayout.SOUTH);
		this.setJMenuBar(m_menuBar);
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