package org.example.repository;

import org.example.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
    Table findByNumber(Integer number);
}