package fr.uvsq._1;

import java.time.LocalDate;

import fr.uvsq._1.Personnel.builder;

public class main {

    public static void main(String[] args) {
        builder b = new builder("charl","atant",LocalDate.of(1, 1, 1),1);
        Personnel p = b.build();
        builder b2 = new builder("glob","glob",LocalDate.of(1, 1, 1),2);
        Personnel p2 = b2.build();
        DAO<Personnel> DAOP = DAOFactory.getPersonnelDAO();
        System.out.println(DAOP.find("1").toString());

    }

}
