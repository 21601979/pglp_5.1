package fr.uvsq._1;
/**
 * factory de DAO.
 * @author Tanguy
 */
public class DAOFactory {
    /**
     * methode qui crée un personnel DAO.
     * @return dao de personnel
     */
    public static DAO<Personnel> getPersonnelDAO() {
        return new PersonnelDAO();
    }
    /**
     * methode qui crée un GoupeComposite DAO.
     * @return dao DE GroupeComposite
     */
    public static DAO<GroupeComposite> getGroupeCompositeDAO() {
        return new GoupeCompositeDAO();
    }
}
