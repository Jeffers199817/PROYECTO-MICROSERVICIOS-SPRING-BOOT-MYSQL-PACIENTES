package com.mileyumsoft.turnos.controller;

import com.mileyumsoft.turnos.dto.TurnoDTO;
import com.mileyumsoft.turnos.model.Turno;
import com.mileyumsoft.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;


    //1.- Crear un nuevo turno

    @PostMapping("/turno/crear")
    public String crearTurno(@RequestBody TurnoDTO turnoDTO) {

        LocalDate fecha = turnoDTO.getFecha();
        String tratamiento = turnoDTO.getTratamiento();
        String dniPaciente = turnoDTO.getDniPaciente();

        turnoService.saveTurno(fecha, tratamiento, dniPaciente);
        return "Turno creado correctamente";
    }

    //2.- Obtener todos los turnos

    @GetMapping("/turno/traer")
    public List<Turno> traerTurno() {

        return turnoService.getTurno();
    }

    //3.- Eliminar un turno

    @DeleteMapping("/turno/borrar/{id}")
    public String deleteTurno(@PathVariable Long id) {

        turnoService.deleteTurno(id);
        return "Turno eliminado correctamente";
    }

    //4.- Editar Turno
    @PutMapping("/turno/editar/{id_original}")
    public Turno editTurno(@PathVariable Long id_original, @RequestBody Turno turno) {

        turnoService.editTurno(id_original, turno);

        Turno turnoEditado = turnoService.findTurno(id_original);
        return turnoEditado;
    }

    //5.- Obtener un turno en particular
    @GetMapping("/turno/traer/{id}")
    public Turno traerPaciente(@PathVariable Long id) {

        System.out.println("final 1");
        return turnoService.findTurno(id);


    }


}
