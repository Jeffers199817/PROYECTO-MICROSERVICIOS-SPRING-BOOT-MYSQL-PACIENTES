package com.milenyumsoft.turnoscloud.service;

import java.time.LocalDate;

public interface IITurnoServic {

    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);
}
