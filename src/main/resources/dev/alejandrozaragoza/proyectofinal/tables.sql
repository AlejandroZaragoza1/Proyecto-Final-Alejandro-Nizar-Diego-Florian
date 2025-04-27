CREATE TABLE IF NOT EXISTS Personas (
    id IDENTITY PRIMARY KEY,
    nombre VARCHAR NOT NULL,
    apellidos VARCHAR NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    fecha_incorporacion DATE NOT NULL,
    salario INT NOT NULL,
    pais VARCHAR NOT NULL,
    rol VARCHAR NOT NULL,
    especialidad VARCHAR NOT NULL,
    posicion VARCHAR NOT NULL,
    dorsal INT NOT NULL,
    altura DOUBLE NOT NULL,
    peso DOUBLE NOT NULL,
    goles INT NOT NULL,
    partidos_jugados INT NOT NULL
);