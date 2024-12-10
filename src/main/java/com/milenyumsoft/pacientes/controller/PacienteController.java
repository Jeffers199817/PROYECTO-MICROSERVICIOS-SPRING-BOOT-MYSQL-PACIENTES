package com.milenyumsoft.pacientes.controller;

import com.milenyumsoft.pacientes.model.Paciente;
import com.milenyumsoft.pacientes.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;


    //1.- Crear un nuevo paciente

    @PostMapping("/pacientes/crear")
    public String crearPaciente(@RequestBody Paciente paciente) {
        pacienteService.savePaciente(paciente);
        return "Paciente creado correctamente";
    }

    //2.- Obtener todos los pacientes

    @GetMapping("/pacientes/traer")
    public List<Paciente> traerPacientes() {

        return pacienteService.getPacientes();
    }

    //3.- Eliminar un paciente

    @DeleteMapping("/pacientes/borrar/{id}")
    public String deletePaciente(@PathVariable Long id) {

        pacienteService.deletePaciente(id);
        return "Paciente eliminado correctamente";
    }



}
