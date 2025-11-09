package br.com.locadora_veiculos.model.dao;

import java.util.List;

public interface Dao<T> {
    public void create(T dataEntry) throws Exception;
    public List<T> readAll()throws Exception;
    public T readOne(Long id)throws Exception;
    public void updateOne(T dataEntry)throws Exception;
    public void deleteOne(T dataEntry)throws Exception;
    public void deleteAll()throws Exception;
}
