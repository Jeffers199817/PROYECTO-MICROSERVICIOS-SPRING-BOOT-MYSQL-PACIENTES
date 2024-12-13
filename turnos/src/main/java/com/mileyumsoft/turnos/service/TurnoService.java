package com.mileyumsoft.turnos.service;


import com.mileyumsoft.turnos.model.Paciente;
import com.mileyumsoft.turnos.model.Turno;
import com.mileyumsoft.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private RestTemplate apiConsumir;

    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public List<Turno> getTurno() {
        return turnoRepository.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        System.out.println("llegue aqui.");

    //buscar el paciente en la api paciente
     Paciente pac = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/"+ dniPaciente, Paciente.class);

    String nombreCompletoPaciente = pac.getNombre() + " " + pac.getApellido();



    Turno turno = new Turno();
    turno.setFecha(fecha);
    turno.setTratamiento(tratamiento);
    turno.setNombreCompletoPaciente(nombreCompletoPaciente);

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

    turnoRepository.save(turnoOriginal);

    }
}
