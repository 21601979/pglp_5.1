package fr.uvsq._1;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Tanguy
 *class personnel.
 */
final class Personnel  implements Groupe {
    /**
     * nom du personnel.
     */
    private String nom;
    /**
     * prenom du personnel.
     */
    private String prenom;
    /**
     * fonction du personnel.
     */
    private String fonctions;
    /**
     * date de naissance du personnel.
     */
    private LocalDate dateNaissance;
    /**
     * liste des numéros de telephone d'un personnel.
     */
    private ArrayList<String> telephone;

    /**
     * @author Tanguy
     *builder qui permet de construire un objet personnel.
     */
    public static class builder {
        /**
         * nom d'un personnel.
         */
        private final String nom;
        /**
         * prenom d'un personnel.
         */
        private final String prenom;
        /**
         * fonction d'un personnel.
         */
        private String fonctions;
        /**
         * date de naissance d'un personnel.
         */
        private LocalDate dateNaissance;
        /**
         * liste des numéros de telephone d'un personnel.
         */
        private ArrayList<String> telephone;
        /**
         * construction du builder.
         * @param nom nom
         * @param prenom prenom
         * @param dateNaissance date de naissance
         */
        builder(final String nom, final String prenom,
                final LocalDate dateNaissance) {
            this.nom = nom;
            this.prenom = prenom;
            this.setDateNaissance(dateNaissance);
            this.fonctions = "";
            this.telephone = new ArrayList<String>();
            }
        /**
         * methode qui ajoute une date de naissance .
         * @param dateNaissance date de naissance
         */
        private void setDateNaissance(LocalDate dateNaissance) 
        {
            this.dateNaissance  = dateNaissance;    
        }

        /**
         * methode qui ajoute une fonction.
         * @param fonction fonction du personnel
         */
        public void setfonction(final String fonction) {
            this.fonctions = fonction;
            }
        /**
         * methode qui ajoute un numéro de telephone.
         * @param tel nume de telephone
         */
        public void settelephone(final String tel) {
            this.telephone.add(tel);
            }
        /**
         * methode qui construit un objet personnel .
         * @return retourne un objet personnel.
         */
        public Personnel build() {
            return new Personnel(this);
            }

        /**
         * 
         */
        public String toString()
        {
            return telephone.toString() + " " + fonctions + " " + dateNaissance.toString() + " " + prenom + " " + nom;
        }
        }
    /**
    * methode qui affiche dans le terminal le nom/prenom .
    * @param i profondeur
    */
    public void affiche(final int i) {
        int j;
        for (j = 0; j < i; j++) {
            System.out.println("-");
            }
        System.out.println(nom  + " " + prenom + "\n");
        }

    /**
     * constructeur de l'objet personnel.
     * @param b builder
     */
    private Personnel(final builder b) {
        this.nom = b.nom;
        this.prenom = b.prenom;
        this.fonctions = b.fonctions;
        this.dateNaissance = b.dateNaissance;
        this.telephone = b.telephone;
        }

    /**
     * @return String 
     */
    public String toString()
    {
        return telephone.toString() + " " + fonctions + " " + dateNaissance.toString() + " " + prenom + " " + nom;
    }
}
