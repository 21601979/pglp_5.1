package fr.uvsq._1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;

import org.junit.Test;

import fr.uvsq._1.Personnel.builder;

public class PersonnelDAOTest {
    @Test
    public void PersonnelDAOSerialisationTest()
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
    public void CreateFindTest() throws existeDejaException{
        File del = new File("Personnel\\" + 1);
        del.delete();
        builder b = new builder("charl","atant",LocalDate.of(1, 1, 1),1);
        Personnel p = b.build();
        DAO<Personnel> DAOP = DAOFactory.getPersonnelDAO();
        DAOP.Create(p);
        assertEquals(DAOP.find("1").toString(),p.toString());
    }

    @Test
    public void DeletTest() throws existeDejaException {
        File del = new File("Personnel\\" + 1);
        del.delete();
        builder b = new builder("charl","atant",LocalDate.of(1, 1, 1),1);
        Personnel p = b.build();
        DAO<Personnel> DAOP = DAOFactory.getPersonnelDAO();
        DAOP.Create(p);
        DAOP.delete(p);
        
        assertTrue(DAOP.find("1") == null);
    }
    
    @Test
    public void UpdateTest() throws existeDejaException {
        File del = new File("Personnel\\" + 1);
        del.delete();
        builder b = new builder("charl","atant",LocalDate.of(1, 1, 1),1);
        Personnel p = b.build();
        DAO<Personnel> DAOP = DAOFactory.getPersonnelDAO();
        DAOP.Create(p);
        builder b2 = new builder("charl","atant",LocalDate.of(10, 10, 10),1);
        Personnel p2 = b.build();
        DAOP.update(p2);
        assertEquals(p2.toString(),DAOP.find("1").toString());
    }
}
