package fr.uvsq._1;
/**
 * factory de DAO.
 * @author Tanguy
 * @param <T> objet
 */
public abstract class DAO<T> {

    /**
     * methode abstraite de serialisation.
     * @param obj objet a sérialiser
     * @param file fichier ou serialiser
     */
    public abstract void serialize(T obj, String file);
    /**
     * methode abstraite pour desérialiser un objet.
     * @param file fichier d'entré
     * @return objet désérialisé
     */
    public abstract T deserialize(String file);
    /**
     * methode pour sauvegarder un objet.
     * @param obj objet a sauvegarder
     * @throws ExisteDejaException exception qui est
     * renvoyé si l'objet est déja sauvegardé.
     */
    public abstract void create(T obj) throws ExisteDejaException;
    /**
     * methode qui retrouve un objet sauvegardé.
     * @param iD id de l'objet a retrouver
     * @return l'objet correspondant a l'id ou null si il n'existe pas
     */
    public abstract T find(String iD);
    /**
     * methode qui supprime un objet.
     * @param obj objet a suprimé
     */
    public abstract void delete(T obj);
    /**
     * methode qui update un objet.
     * @param obj a suprimer
     * @return retour de l'objet update
     */
    public abstract T update(T obj);
}
