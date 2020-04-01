package fr.uvsq._1;

public abstract class DAO<T> {

    public abstract T serialize(T obj);
    public abstract T deserialize(String file);
}
