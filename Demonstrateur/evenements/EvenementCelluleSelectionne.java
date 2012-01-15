package evenements;

import evenements.menu.contextuel.EvenementDebutSequence;
import com.mxgraph.model.mxCell;
import eltGraphique.Acteur;
import eltGraphique.ElementGraphique;
import eltGraphique.Traitement;
import eltGraphique.classe.Classe;
import evenements.menu.contextuel.EvenementLigneDeVie;
import evenements.menu.contextuel.EvenementSupprimer;
import ihm.FenetreDemo;
import ihm.PanneauGraph;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Cette classe permet de gérer les actions produites lors de la selection de la cellule.
 */
public class EvenementCelluleSelectionne implements MouseListener {
    private final PanneauGraph panneauGraph;

    private final FenetreDemo fenetre;


    public EvenementCelluleSelectionne(PanneauGraph p_graph, FenetreDemo p_fenetre){
        this.panneauGraph = p_graph;
        
        this.panneauGraph.getGraphControl().addMouseListener(this);
        this.fenetre = p_fenetre;
    }
    
    /**
    * Cette classe permet de gérer les actions produites lors d'un click avec la souris.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        ElementGraphique element = this.panneauGraph.getDiagramme().getElementGraphiqueViaCellule((mxCell)
            this.panneauGraph.getGraph().getSelectionCell());
        
    }   

    /**
    * Cette classe permet de gérer les actions produites lors d'une pression avec la souris.
    * @param arg0 évènement en cours
    */
    @Override
    public void mousePressed(MouseEvent arg0) { }

    /**
    * Cette classe permet de gérer les actions produites lors d'une release avec la souris.
    * @param event évènement en cours
    */
    @Override
    public void mouseReleased(MouseEvent event) {
		ElementGraphique element = this.panneauGraph.getDiagramme().getElementGraphiqueViaCellule(
				(mxCell) this.panneauGraph.getGraph().getSelectionCell());
                JPopupMenu menuContextuel;
                
		if(element != null){
                    if(element instanceof Classe) {
                        this.fenetre.getPanneauDroite().afficherTableauClasse((Classe) element);
                        // TODO ici, c'est que c'est une classe, on pourra donc afficher le supertableau de la
                        // mort qui tue -- Le tableau ne s'affiche qu'avec un clic droit ?!
                    }
			if(event.getButton() == MouseEvent.BUTTON3){
                            if(element instanceof Acteur){
                                menuContextuel = construireMenuContextuel((Acteur) element);
                            } else if (element instanceof Traitement){
                                menuContextuel = construireMenuContextuel((Traitement) element);                                
                            } else {
                                menuContextuel = construireMenuContextuel((ElementGraphique) element);                                
                            }
                            
                            /* On affiche le menu contextuel*/
                            menuContextuel.show(this.fenetre.getPanneauPrincipal(), event.getX(),event.getY());
                            menuContextuel.show(this.panneauGraph, event.getX(), event.getY());
			}
		}
	}
    
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    
    @Override
    public void mouseExited(MouseEvent arg0) {}
    
    // Méthode permettant d'afficher le menu contextuel au clique sur un Acteur
    private JPopupMenu construireMenuContextuel(Acteur element){
	JPopupMenu menuContextuel = new JPopupMenu();
	
        JMenuItem itemSupprimer = new JMenuItem("Supprimer");
        EvenementSupprimer evenementSupprimer = new EvenementSupprimer(element);
        
        JMenuItem itemLigneDeVie;
        String texteItemLigneDeVie;
        EvenementLigneDeVie evenementAfficherLigneDeVie = new EvenementLigneDeVie(element);

        texteItemLigneDeVie = 
            (element.getVisibiliteLigneDeVie()) ? "Ne pas afficher ligne de vie" : "Afficher ligne de vie";
        itemLigneDeVie = new JMenuItem(texteItemLigneDeVie);
        
        menuContextuel.add(itemSupprimer);
        menuContextuel.add(itemLigneDeVie);
        this.fenetre.getPanneauPrincipal().add(menuContextuel);
        
        itemSupprimer.addActionListener(evenementSupprimer);
        itemLigneDeVie.addActionListener(evenementAfficherLigneDeVie);
        
        return menuContextuel;
    }
    
    // Méthode permettant de constuire le menu contextuel lors de la séléction d'un traitement
    private JPopupMenu construireMenuContextuel(Traitement element){
	JPopupMenu menuContextuel = new JPopupMenu();
	
        JMenuItem itemSupprimer = new JMenuItem("Supprimer");
        EvenementSupprimer evenementSupprimer = new EvenementSupprimer(element);
        
        JMenuItem itemLigneDeVie;
        String texteItemLigneDeVie;
        EvenementDebutSequence evenementDebutSequence = new EvenementDebutSequence(element);

        texteItemLigneDeVie = 
            (element.estDebutSequence()) ? "Ne pas afficher la flèche de début de séquence" : 
                "Afficher la flèche de début de séquence";
        itemLigneDeVie = new JMenuItem(texteItemLigneDeVie);
        
        menuContextuel.add(itemSupprimer);
        menuContextuel.add(itemLigneDeVie);
        this.fenetre.getPanneauPrincipal().add(menuContextuel);
        
        itemSupprimer.addActionListener(evenementSupprimer);
        itemLigneDeVie.addActionListener(evenementDebutSequence);
        
        return menuContextuel;
    }   
    
    // Méthode permettant de constuire le menu contextuel en ajoutant un élément graphique.
    private JPopupMenu construireMenuContextuel(ElementGraphique element){
	JPopupMenu menuContextuel = new JPopupMenu();
	
        JMenuItem itemSupprimer = new JMenuItem("Supprimer");
        EvenementSupprimer evenementSupprimer = new EvenementSupprimer(element);
        
        JMenuItem itemLigneDeVie;

        menuContextuel.add(itemSupprimer);
        this.fenetre.getPanneauPrincipal().add(menuContextuel);
        
        itemSupprimer.addActionListener(evenementSupprimer);

        return menuContextuel;
    }    
    /* TODO Relire la javaDoc */
}