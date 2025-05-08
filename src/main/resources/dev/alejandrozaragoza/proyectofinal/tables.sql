CREATE TABLE IF NOT EXISTS Personas (
    id IDENTITY PRIMARY KEY,
    nombre VARCHAR NOT NULL,
    apellidos VARCHAR NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    fecha_incorporacion DATE NOT NULL,
    salario INT NOT NULL,
    pais VARCHAR NOT NULL,
    rol VARCHAR NOT NULL CHECK (tipo IN ('ENTRENADOR', 'JUGADOR')),
    especialidad VARCHAR NOT NULL CHECK (especializacion IN ('ENTRENADOR_PRINCIPAL', 'ENTRENADOR_ASISTENTE', 'ENTRENADOR_PORTERO')),
    posicion VARCHAR NOT NULL CHECK (posicion IN ('DEFENSA', 'PORTERO', 'MEDIOCENTRO', 'DELANTERO')),
    dorsal INTEGER NOT NULL,
    altura DOUBLE NOT NULL,
    peso DOUBLE NOT NULL,
    goles INTEGER NOT NULL DEFAULT 0,
    partidos_jugados INTEGER NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);