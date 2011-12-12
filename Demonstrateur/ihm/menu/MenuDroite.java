package ihm.menu;

import ihm.FenetreDemo;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author satenske
 */
public class MenuDroite extends Menu {
    public MenuDroite (int p_largeurPanneau, int p_longueurPanneau, FenetreDemo p_fenetre){
        super(p_largeurPanneau, p_longueurPanneau, p_fenetre);
    }

    @Override
    public void ajouterObjetsGraphiques() {
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
        super.add(new JScrollPane(tableau));
    }

}
