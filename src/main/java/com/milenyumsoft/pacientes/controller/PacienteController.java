package com.milenyumsoft.pacientes.controller;

import com.milenyumsoft.pacientes.model.Paciente;
import com.milenyumsoft.pacientes.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;


    //1.- Crear un nuevo paciente

    @PostMapping("/pacientes/crear")
    public String crearPaciente(@RequestBody Paciente paciente) {
        return "Paciente creado correctamente";
    }

}
