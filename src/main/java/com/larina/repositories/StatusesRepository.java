package com.larina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.larina.model.Status;

@Repository
public interface StatusesRepository extends JpaRepository<Status, Long> {

}
