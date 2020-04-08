package fr.uvsq._1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GoupeCompositeDAO extends DAO<GroupeComposite>{

    @Override
    public void serialize(GroupeComposite obj, String file) {
        ObjectOutputStream out = null;
        try {
          final FileOutputStream fichier = new FileOutputStream(file);
          out = new ObjectOutputStream(fichier);
          out.writeObject(obj);
          out.flush();
        } catch (java.io.IOException e) {
          e.printStackTrace(); 
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GroupeComposite deserialize(String file) {
        ObjectInputStream in = null;
        GroupeComposite ret = null;
        try {
            final FileInputStream fichier = new FileInputStream(file);
            in = new ObjectInputStream(fichier);
            ret = (GroupeComposite) in.readObject();
            fichier.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
        return ret;
    }

    @Override
    public void Create(GroupeComposite obj) throws existeDejaException {
        int i;
        File repertoire = new File("GroupeComposite");
        String liste[] = repertoire.list();
        if(liste.length == 0){
        }
        else {
            for(i=0;i<liste.length;i++) {
                if(Integer.parseInt(liste[i]) == obj.getID()) {
                    throw new existeDejaException(); 
                }
            }
        }
        this.serialize(obj,"GroupeComposite\\" + (obj.getID()));
    }

    @Override
    public GroupeComposite find(String ID) {
        int i;
        File repertoire = new File("GroupeComposite");
        String liste[] = repertoire.list();
        if(liste.length == 0){
            return null;
        }
        else {
            for(i=0;i<liste.length;i++) {
                if(liste[i].equals(ID)) {
                    return this.deserialize("GroupeComposite\\" + liste[i]);
                }
            }
        }
        return null;
    }

    @Override
    public void delete(GroupeComposite obj) {
        if(this.find(obj.getID()+"") != null){
            File del = new File("GroupeComposite\\" + obj.getID());
            del.delete();
        }
    }

    @Override
    public GroupeComposite update(GroupeComposite obj) {
        GroupeComposite up = this.find(obj.getID()+"");
        if(up != null) {
            this.delete(up);
            try {
                this.Create(obj);
            } catch (existeDejaException e) {
                return null;
            }
            return obj;
        }
        return null;
    }

}
