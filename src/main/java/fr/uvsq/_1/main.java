package fr.uvsq._1;

import java.io.File;
import java.time.LocalDate;

import fr.uvsq._1.Personnel.builder;

public class main {

    public static void main(String[] args) {
        File del = new File("GroupeComposite\\" + 1);
        del.delete();
        
        GroupeComposite g = new GroupeComposite(3);  
        DAO<GroupeComposite> DAOP = DAOFactory.getGroupeCompositeDAO();
        DAOP.delete(g);
    }

}
