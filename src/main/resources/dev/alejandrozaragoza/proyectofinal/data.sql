DELETE
FROM personas;

ALTER TABLE personas
    ALTER COLUMN id RESTART WITH 1;

INSERT INTO personas(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais, rol,
                     especialidad, posicion, dorsal, altura, peso, goles, partidos_jugados, created_at, updated_at)
VALUES ('21', 'Carlos', 'Santana', '1985-01-15', '2002-03-01', '33000.0', 'Brasil', 'Jugador', '', 'Delantero', '9', '1.82', '74.0', '50', '140', '2024-04-26T18:54:47.097563500', '2024-04-26T18:54:47.097563500');