package ru.ma3x.rest.services;


import java.util.List;

public interface BaseService<T> {
    void create(T obj);

    List<T> getAll();

    T get(long id);

    boolean update(T obj, long id);

    boolean delete(long id);
}
