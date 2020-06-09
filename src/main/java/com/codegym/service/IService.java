package com.codegym.service;

public interface IService<T, Long> {
    T save(T model) throws Exception;
}
