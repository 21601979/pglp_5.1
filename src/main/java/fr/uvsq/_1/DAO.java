package fr.uvsq._1;

public abstract class DAO<T> {

    public abstract void serialize(T obj, String file);
    public abstract T deserialize(String file);
}
