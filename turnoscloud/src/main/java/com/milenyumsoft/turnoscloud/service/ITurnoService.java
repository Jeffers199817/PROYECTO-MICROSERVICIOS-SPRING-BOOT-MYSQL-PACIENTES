package com.milenyumsoft.turnoscloud.service;



import com.milenyumsoft.turnoscloud.model.Turno;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {

    public List<Turno> getTurno();

    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);

    public void deleteTurno(Long id);

    public Turno findTurno(Long id);

    public void editTurno(Long id_original, Turno turno);


}
