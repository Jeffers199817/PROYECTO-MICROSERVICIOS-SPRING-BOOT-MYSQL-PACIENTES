package com.milenyumsoft.pacientes.service;

import com.milenyumsoft.pacientes.model.Paciente;
import com.milenyumsoft.pacientes.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PacienteService implements IPacienteService {



    @Autowired
    private IPacienteRepository pacienteRepository;


    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public void savePaciente(Paciente paciente) {

        pacienteRepository.save(paciente);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    public void editPaciente(Long id_original, Paciente paciente) {

       Paciente pac =  this.findPaciente(id_original);
       pac.setDni(paciente.getDni());
       pac.setNombre(paciente.getNombre());
       pac.setApellido(paciente.getApellido());
       pac.setFechaNac(paciente.getFechaNac());
       pac.setTelefono(paciente.getTelefono());
       this.savePaciente(pac);
        System.out.println("Paciente editado correctamente");
    }


    //Traer un paciente por DNI
    @Override
    public Paciente findPacienteByDni(String dni) {

        return pacienteRepository.findPacienteByDni(dni);
    }

}
