package com.felper.tst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felper.tst.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
