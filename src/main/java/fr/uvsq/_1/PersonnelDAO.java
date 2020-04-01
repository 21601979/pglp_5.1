package fr.uvsq._1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonnelDAO extends DAO<Personnel>{

    @Override
    public void serialize(Personnel obj, String file) {
        ObjectOutputStream out = null;
        try {
          final FileOutputStream fichier = new FileOutputStream("test");
          out = new ObjectOutputStream(fichier);
          out.writeObject(obj);
          out.flush();
        } catch (java.io.IOException e) {
          e.printStackTrace(); 
        } 
    }

    @Override
    public Personnel deserialize(String file) {
        ObjectInputStream in = null;
        Personnel ret = null;
        try {
            final FileInputStream fichier = new FileInputStream("test");
            in = new ObjectInputStream(fichier);
            ret = (Personnel) in.readObject();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
        return ret;
    }
}
