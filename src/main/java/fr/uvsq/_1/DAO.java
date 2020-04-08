package fr.uvsq._1;

public abstract class DAO<T> {

    public abstract void serialize(T obj, String file);
    public abstract T deserialize(String file);
    
    public abstract void Create(T obj) throws existeDejaException;
    public abstract T find(String ID);
    public abstract void delete(T obj);
    public abstract T update(T obj);
}