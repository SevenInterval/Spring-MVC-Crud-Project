package com.springframework.springmvc.services;

import com.springframework.springmvc.domain.DomainObject;

import java.util.*;

public abstract class AbstractMapService {
    protected Map<Integer, DomainObject> domainMap;

    /**
     *
     */
    public AbstractMapService() {
        domainMap = new HashMap<>();
        loadDomainObjects();
    }

    /**
     * @return
     */
    public List<DomainObject> listAll() {
        return new ArrayList<>(domainMap.values());
    }

    /**
     * @param id
     * @return
     */
    public DomainObject getById(Integer id) {
        return domainMap.get(id);
    }

    /**
     * @param domainObject
     * @return
     */
    public DomainObject saveOrUpdate(DomainObject domainObject) {
        if (domainObject != null){

            if (domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(), domainObject);

            return domainObject;
        } else {
            throw new RuntimeException("Object Can't be null");
        }
    }

    /**
     * @param id
     */
    public void delete(Integer id) {
        domainMap.remove(id);
    }

    /**
     * @return
     */
    private Integer getNextKey(){
        return Collections.max(domainMap.keySet()) + 1;
    }

    /**
     *
     */
    protected abstract void loadDomainObjects();

}
