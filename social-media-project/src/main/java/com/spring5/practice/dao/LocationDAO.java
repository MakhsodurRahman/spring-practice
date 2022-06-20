package com.spring5.practice.dao;

import com.spring5.practice.entity.Location;

import java.util.List;

public interface LocationDAO {
    public void insert(Location location);
    public List<Location> getAll();

    public void update(Location location);

    public Location getByName(String name);
}
