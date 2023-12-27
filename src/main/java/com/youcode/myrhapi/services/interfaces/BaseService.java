package com.youcode.myrhapi.Services.Interfaces;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T> {
    List<T> findAll();
    T findById(Long id);
    T create(T item);
    T update(T item);
    void deleteById(Long id);
}
