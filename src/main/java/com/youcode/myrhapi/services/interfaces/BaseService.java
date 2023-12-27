package com.youcode.myrhapi.services.interfaces;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BaseService<T> {
    List<T> getAll();
    Optional<T> getById(Long id);
    Optional<T> create(T item);
    Optional<T> update(T item);
    void deleteById(Long id);
}
