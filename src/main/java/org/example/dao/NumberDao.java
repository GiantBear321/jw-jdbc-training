package org.example.dao;

import org.example.model.Number;

public interface NumberDao {
    public Number get(Long id);

    public Number save(Number number);
}
