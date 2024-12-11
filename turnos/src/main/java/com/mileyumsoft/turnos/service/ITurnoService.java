package com.mileyumsoft.turnos.service;

import com.mileyumsoft.turnos.model.Turno;

import java.util.List;

public interface ITurnoService {

    public List<Turno> getTurno();

    public void saveTurno(Turno turno);

    public void deleteTurno(Long id);

    public Turno findTurno(Long id);

    public void editTurno(Long id_original, Turno turno);

}
