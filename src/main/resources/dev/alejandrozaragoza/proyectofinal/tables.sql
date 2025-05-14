/*CREATE TABLE IF NOT EXISTS Personas (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(100) NOT NULL,
                                        apellidos VARCHAR(100) NOT NULL,
                                        fecha_nacimiento DATE NOT NULL,
                                        fecha_incorporacion DATE NOT NULL,
                                        salario INT NOT NULL,
                                        pais VARCHAR(100) NOT NULL,
                                        rol VARCHAR(20) NOT NULL CHECK (rol IN ('ENTRENADOR', 'JUGADOR')),
                                        especialidad VARCHAR(30) NOT NULL CHECK (especialidad IN ('ENTRENADOR_PRINCIPAL', 'ENTRENADOR_ASISTENTE', 'ENTRENADOR_PORTERO')),
                                        posicion VARCHAR(20) NOT NULL CHECK (posicion IN ('DEFENSA', 'PORTERO', 'MEDIOCENTRO', 'DELANTERO')),
                                        dorsal INT NOT NULL,
                                        altura DECIMAL(5,2) NOT NULL,
                                        peso DECIMAL(5,2) NOT NULL,
                                        goles INT NOT NULL DEFAULT 0,
                                        partidos_jugados INT NOT NULL DEFAULT 0,
                                        created_at TIMESTAMP NOT NULL,
                                        updated_at TIMESTAMP NOT NULL
); */
CREATE TABLE IF NOT EXISTS Personas (
                                        id IDENTITY AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(100) NOT NULL,
                                        apellido VARCHAR(100) NOT NULL,
                                        fecha_nacimiento DATE NOT NULL,
                                        fecha_incorporacion DATE NOT NULL,
                                        salario DOUBLE NOT NULL,
                                        pais VARCHAR(100) NOT NULL,
                                        rol VARCHAR(20) NOT NULL CHECK (rol IN ('ENTRENADOR', 'JUGADOR')),
                                        created_at TIMESTAMP NOT NULL,
                                        updated_at TIMESTAMP NOT NULL
);
CREATE TABLE IF NOT EXISTS Entrenador (
                                          id IDENTITY PRIMARY KEY,
                                          especialidad VARCHAR(30) NOT NULL CHECK (
                                              especialidad IN ('ENTRENADOR_PRINCIPAL', 'ENTRENADOR_ASISTENTE', 'ENTRENADOR_PORTEROS')
                                              ),
                                          FOREIGN KEY (id) REFERENCES Personas(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS Jugador (
                                       id IDENTITY PRIMARY KEY,
                                       posicion VARCHAR(20) NOT NULL CHECK (
                                           posicion IN ('DEFENSA', 'CENTROCAMPISTA', 'DELANTERO', 'PORTERO', 'NINGUNO')
                                           ),
                                       dorsal INT NOT NULL,
                                       altura DOUBLE NOT NULL,
                                       peso DOUBLE NOT NULL,
                                       goles INT DEFAULT 0,
                                       partidos_jugados INT DEFAULT 0,
                                       minutos_jugados DOUBLE DEFAULT 0,
                                       FOREIGN KEY (id) REFERENCES Personas(id) ON DELETE CASCADE
);

