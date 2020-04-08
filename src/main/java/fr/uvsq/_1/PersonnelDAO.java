package fr.uvsq._1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonnelDAO extends DAO<Personnel>{

    @Override
    public void serialize(Personnel obj, String file) {
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
    public Personnel deserialize(String file) {
        ObjectInputStream in = null;
        Personnel ret = null;
        try {
            final FileInputStream fichier = new FileInputStream(file);
            in = new ObjectInputStream(fichier);
            ret = (Personnel) in.readObject();
            fichier.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
        return ret;
    }

    @Override
    public void Create(Personnel obj) throws existeDejaException {
        int i;
        File repertoire = new File("Personnel");
        String liste[] = repertoire.list();
        for(i=0;i<liste.length;i++) {
            if(Integer.parseInt(liste[i]) == obj.getID()) {
                throw new existeDejaException(); 
            }
        }
        this.serialize(obj,"Personnel\\" + (obj.getID()));
    }

    @Override
    public Personnel find(String ID) {
        int i;
        File repertoire = new File("Personnel");
        String liste[] = repertoire.list();
        if(liste.length == 0){
            return null;
        }
        else {
            for(i=0;i<liste.length;i++) {
                if(liste[i].equals(ID)) {
                    return this.deserialize("Personnel\\" + liste[i]);
                }
            }
        }
        return null;
    }

    @Override
    public void delete(Personnel obj) {
        if(this.find(obj.getID()+"") != null){
            File del = new File("Personnel\\" + obj.getID());
            del.delete();
        }
    }

    @Override
    public Personnel update(Personnel obj) {
        Personnel up = this.find(obj.getID()+"");
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
