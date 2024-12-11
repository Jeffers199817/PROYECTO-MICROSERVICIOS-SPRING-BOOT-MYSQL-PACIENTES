package com.mileyumsoft.turnos.service;


import com.mileyumsoft.turnos.model.Turno;
import com.mileyumsoft.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public List<Turno> getTurno() {
        return turnoRepository.findAll();
    }

    @Override
    public void saveTurno(Turno turno) {
    turnoRepository.save(turno);
    }

    @Override
    public void deleteTurno(Long id) {
    turnoRepository.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepository.findById(id).get();
    }

    @Override
    public void editTurno(Long id_original, Turno turno) {
    Turno turnoOriginal = this.findTurno(id_original);
    turnoOriginal.setFecha(turno.getFecha());
    turnoOriginal.setTratamiento(turno.getTratamiento());
    turnoOriginal.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

    this.saveTurno(turnoOriginal);

    }
}
