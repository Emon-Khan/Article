package com.emonkhan.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    public List<T> getAll();
    public Optional<T> get(int id);
    public void save(T t);
    public void update(T t, String[] params);
    public void delete(T t);
}
