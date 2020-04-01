package fr.uvsq._1;

public class DAOFactory {

    public static DAO<Personnel> getPersonnelDAO(){
        return new PersonnelDAO();
    }
}
