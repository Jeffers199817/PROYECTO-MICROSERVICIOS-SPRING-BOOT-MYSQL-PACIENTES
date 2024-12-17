package com.milenyumsoft.turnoscloud.repository;


import com.milenyumsoft.turnoscloud.model.Paciente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "paciente", url="http://localhost:9001")
public interface IITurnoRepository {

    @GetMapping("/pacientes/traerdni/{dni}")
    public Paciente getPacienteByDni(@PathVariable("dni") String dni);



}
