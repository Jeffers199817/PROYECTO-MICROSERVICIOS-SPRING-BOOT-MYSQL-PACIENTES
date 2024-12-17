package com.milenyumsoft.turnoscloud.repository;


import com.milenyumsoft.turnoscloud.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {




}
