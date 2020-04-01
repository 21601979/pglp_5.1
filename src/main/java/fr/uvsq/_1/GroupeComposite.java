package fr.uvsq._1;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @author Tanguy
 *class groupe composite.
 */
public class GroupeComposite implements Groupe, Serializable {
    /**
     * num de serialisation
     */
    private static final long serialVersionUID = -364604849233971037L;
    /**
     * liste de groupe.
     */
    private ListeGroupe l = new ListeGroupe();
    /**
     * methode qui ajoute un groupe composite.
     * @param compo : groupe a ajouter
     */
    public void add(final Groupe compo) {
        getL().add(compo);
        }
    /**
     * methode qui renvoi l'iterateur de groupe composite.
     * @return iterateur
     */
    public Iterator<Groupe> iterator() {
        return getL().iterator();
        }
     /**
      * methode qui affiche un éllement i d'un groupe.
      * @param i artéfacte
      */
    public void affiche(int i) {
        Iterator<Groupe> it = this.iterator();
        while (it.hasNext()) {
            i++;
            ((GroupeComposite) it.next()).affiche(i);
            }
        }
    /**
     * @return liste l
     */
    public ListeGroupe getL() {
        return l;
    }
    
    public String toString() {
        String temp = "";
        Iterator<Groupe> it = this.iterator();
        while (it.hasNext()) {
            temp = temp + it.next().toString();
            }
        return temp;
    }

}