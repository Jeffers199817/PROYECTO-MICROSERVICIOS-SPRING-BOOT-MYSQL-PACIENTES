package com.milenyumsoft.turnoscloud.service;


import com.milenyumsoft.turnoscloud.model.Paciente;
import com.milenyumsoft.turnoscloud.model.Turno;
import com.milenyumsoft.turnoscloud.repository.IITurnoRepository;
import com.milenyumsoft.turnoscloud.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TurnoServic implements IITurnoServic {

    @Autowired
    private IITurnoRepository turnoRepositor;
    @Autowired
    private ITurnoRepository turnoService;

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {

        Paciente paciente =  turnoRepositor.getPacienteByDni(dniPaciente);
        String nombreCompletoPaciente = paciente.getNombre() + " " + paciente.getApellido();

        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompletoPaciente);

        turnoService.save(turno);

    }
}
