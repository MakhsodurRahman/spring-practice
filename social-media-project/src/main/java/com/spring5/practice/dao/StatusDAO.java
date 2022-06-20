package com.spring5.practice.dao;

import com.spring5.practice.entity.Status;

import java.util.List;

public interface StatusDAO {
    public void insert(Status status);
    public List<Status> getAll();

    public void delete(Long id);

    //public void delete(Long id);
}
