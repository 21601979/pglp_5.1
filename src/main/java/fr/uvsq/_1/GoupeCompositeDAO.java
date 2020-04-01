package fr.uvsq._1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GoupeCompositeDAO extends DAO<GroupeComposite>{

    @Override
    public void serialize(GroupeComposite obj, String file) {
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
    public GroupeComposite deserialize(String file) {
        ObjectInputStream in = null;
        GroupeComposite ret = null;
        try {
            final FileInputStream fichier = new FileInputStream("test");
            in = new ObjectInputStream(fichier);
            ret = (GroupeComposite) in.readObject();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
        return ret;
    }

}
