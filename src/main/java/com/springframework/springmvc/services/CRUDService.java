package com.springframework.springmvc.services;

import java.util.List;

public interface CRUDService<T> {
    List<?> listAll();

    /**
     * @param id
     * @return
     */
    T getById(Integer id);

    /**
     * @param domainObject
     * @return
     */
    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
