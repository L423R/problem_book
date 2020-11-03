package ru.ma3x.rest.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T, R extends JpaRepository<T, Long>> implements BaseService<T> {
    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void create(T obj) {
        repository.save(obj);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T get(long id) {
        Optional<T> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public boolean update(T obj, long id) {
        if (repository.existsById(id)) {
            repository.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
