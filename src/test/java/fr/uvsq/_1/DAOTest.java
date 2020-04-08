package fr.uvsq._1;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import fr.uvsq._1.Personnel.builder;

public class DAOTest {

    @Test
    public void PersonnelDAOTest()
    {
        builder b = new builder("taga","da",LocalDate.of(1, 1, 1),1);
        Personnel p = b.build();
        Personnel p2 = null;
        DAO<Personnel> DAOP = DAOFactory.getPersonnelDAO();
        DAOP.serialize(p, "test");
        p2 = DAOP.deserialize("Test");
        assertEquals(p.toString(),p2.toString());
    }
    
    @Test
    public void GroupeCompositeTestDAO() {
        GroupeComposite g = new GroupeComposite(1);  
        GroupeComposite g2 = new GroupeComposite(2);
        builder b = new builder("charl","atant",LocalDate.of(1, 1, 1),1);
        Personnel p = b.build();
        builder b2 = new builder("bri","oche",LocalDate.of(1, 1, 1),1);
        Personnel p2 = b2.build();
        g.add(p);
        g.add(g2);
        g2.add(p2);
        DAO<GroupeComposite> DAOP = DAOFactory.getGroupeCompositeDAO();
        DAOP.serialize(g, "test");
        GroupeComposite g3 = DAOP.deserialize("Test");
        assertEquals(g.toString(),g3.toString());
    }
}
