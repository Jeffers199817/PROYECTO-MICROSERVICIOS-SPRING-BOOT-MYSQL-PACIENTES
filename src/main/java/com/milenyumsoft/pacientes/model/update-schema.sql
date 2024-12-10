CREATE TABLE paciente
(
    id_paciente BIGINT NOT NULL,
    dni         VARCHAR(255) NULL,
    nombre      VARCHAR(255) NULL,
    apellido    VARCHAR(255) NULL,
    fecha_nac   datetime NULL,
    telefono    VARCHAR(255) NULL,
    CONSTRAINT pk_paciente PRIMARY KEY (id_paciente)
);