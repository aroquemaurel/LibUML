import evenements.EvenementCarre;
import evenements.EvenementBtnFleche;
import evenements.EvenementBtnCarre;

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

	private EvenementBtnCarre m_listenerBtnCarre = new EvenementBtnCarre(panneauPrincipal.getGraph(), this);
	private EvenementCarre m_listenerCarre = new EvenementCarre(panneauPrincipal.getGraph(), this);
	private EvenementBtnFleche m_listenerBtnFleche = new EvenementBtnFleche(panneauPrincipal.getGraph(), this, m_listenerCarre);
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

		m_btnCarre.addMouseListener(m_listenerBtnCarre);
		m_btnFleche.addMouseListener(m_listenerBtnFleche);

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