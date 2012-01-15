package ihm.menu;

import eltGraphique.classe.Classe;
import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import util.Liste;

/**
* Menu contenant le tableau avec les données
*/
public class MenuDroite extends Menu {
    public MenuDroite (Dimension p_dimension, FenetreDemo p_fenetre){
        super(p_dimension, p_fenetre);
    }

    /* Ajoute les objets graphiques du Menu (le tableau) */
    @Override
    public void ajouterObjetsGraphiques() {/*
        Object[][] donnees = {
                {"Private", "boolean", "jeSuisUnattribut","o","n"},
                {"Protected", "int", "jeSuisUnattribut","o","n"},
                {"Protected", "int", "jeSuisUnattribut","o","n"},
                {"Protected", "int", "jeSuisUnattribut","o","n"},
                                {"Protected", "int", "jeSuisUnattribut","o","n"},
                                                {"Protected", "int", "jeSuisUnattribut","o","n"},
                {"Private", "double", "jeSuisUnattribut","o","n"},
                {"Private", "double", "jeSuisUnattribut","o","n"},
                {"Private", "float", "jeSuisUnattribut","o","n"}
            };
        //Les titres des colonnes
        String  title[] = {"Visibilité", "Type", "Nom", "Static", "Final"};
        JTable tableau = new JTable(donnees, title);

        tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn col = tableau.getColumnModel().getColumn(2);
     //    col.setPreferredWidth(200);
        super.add(new JScrollPane(tableau));*/
    }

    public void afficherTableauClasse(Classe classe){
        Object[][] donnees = new Object[classe.getAttributs().size()][5];
        for(int i = 0 ; i < classe.getAttributs().size() ; i++){
            donnees[i][0] = classe.getAttributs().get(i).getVisibilite();
            donnees[i][1] = classe.getAttributs().get(i).getType();
            donnees[i][2] = classe.getAttributs().get(i).getNom();
            donnees[i][3] = classe.getAttributs().get(i).estDeClasse();
            donnees[i][4] = classe.getAttributs().get(i).estConstante();
        }
 
        //Les titres des colonnes
        String  title[] = {"Visibilité", "Type", "Nom", "Static", "Final"};
        JTable tableau = new JTable(donnees, title);

        tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn col = tableau.getColumnModel().getColumn(2);
        super.add(new JScrollPane(tableau));
    }
}
