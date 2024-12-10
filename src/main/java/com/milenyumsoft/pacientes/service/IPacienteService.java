package com.milenyumsoft.pacientes.service;

import com.milenyumsoft.pacientes.model.Paciente;

import java.util.List;

public interface IPacienteService {


    public List<Paciente> getPacientes();

    public void savePaciente(Paciente paciente);

    public void deletePaciente(Long id);

    public Paciente findPaciente(Long id);

    public void editPaciente(Long id_original, Paciente paciente);
}
