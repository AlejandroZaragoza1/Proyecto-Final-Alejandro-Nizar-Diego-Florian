DELETE
FROM personas;

ALTER TABLE personas
    ALTER COLUMN id RESTART WITH 1;

INSERT INTO personas(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais, rol,
                     especialidad, posicion, dorsal, altura, peso, goles, partidos_jugados, created_at, updated_at)
VALUES ('21', 'Carlos', 'Santana', '1985-01-15', '2002-03-01', '33000.0', 'Brasil', 'Jugador', '', 'Delantero', '9', '1.82', '74.0', '50', '140'),
       ('22', 'Miguel', 'Rodriguez', '1982-11-30', '2001-07-15', '34000.0', 'España', 'Jugador', '', 'Centrocampista', '8', '1.76', '70.0', '25', '150'),
       ('23', 'Luca', 'Bianchi', '1987-06-20', '2003-09-10', '32000.0', 'Italia', 'Jugador', '', 'Defensa', '4', '1.85', '78.0', '5', '160'),
       ('24', 'Hans', 'Keller', '1980-04-18', '2000-02-01', '36000.0', 'Alemania', 'Entrenador', 'Entrenador_Asistente', '', 'null', 'null', 'null', 'null', 'null'),
       ('25', 'Juan', 'Perez', '1986-09-25', '2003-04-20', '29000.0', 'México', 'Jugador', '', 'Portero', '1', '1.90', '85.0', '0', '180'),
       ('26', 'Nicolas', 'Gomez', '1984-03-05', '2001-06-11', '31000.0', 'Argentina', 'Jugador', '', 'Delantero', '11', '1.80', '72.0', '45', '135'),
       ('27', 'Takeshi', 'Yamamoto', '1983-07-30', '2001-05-20', '28000.0', 'Japón', 'Jugador', '', 'Centrocampista', '7', '1.74', '68.0', '18', '130'),
       ('28', 'Samuel', 'Johnson', '1981-11-11', '2000-05-25', '37000.0', 'Estados Unidos', 'Entrenador', 'Entrenador_Asistente', '', 'null', 'null', 'null', 'null', 'null'),
       ('29', 'Pierre', 'Dupont', '1985-02-10', '2002-08-15', '30000.0', 'Francia', 'Jugador', '', 'Defensa', '5', '1.83', '75.0', '7', '145'),
       ('30', 'Igor', 'Petrov', '1982-04-04', '2001-09-10', '35000.0', 'Rusia', 'Jugador', '', 'Delantero', '10', '1.88', '80.0', '55', '150'),
       ('31', 'Luisa', 'Martinez', '1987-01-21', '2004-03-15', '31000.0', 'España', 'Jugador', '', 'Centrocampista', '6', '1.70', '65.0', '20', '125'),
       ('32', 'Anita', 'Lopez', '1986-05-12', '2003-07-07', '29000.0', 'Chile', 'Jugador', '', 'Defensa', '3', '1.75', '68.0', '10', '140'),
       ('33', 'Erik', 'Svensson', '1983-09-09', '2001-10-12', '34000.0', 'Suecia', 'Jugador', '', 'Portero', '12', '1.92', '82.0', '0', '170'),
       ('34', 'Alicia', 'Fernandez', '1984-07-17', '2002-05-05', '33000.0', 'España', 'Jugador', '', 'Delantero', '13', '1.77', '70.0', '40', '130'),
       ('35', 'Diego', 'Cruz', '1982-03-03', '2001-01-01', '32000.0', 'Uruguay', 'Jugador', '', 'Centrocampista', '14', '1.78', '72.0', '22', '150'),
       ('36', 'Sofia', 'Gonzalez', '1985-10-10', '2002-11-11', '31000.0', 'Argentina', 'Jugador', '', 'Defensa', '2', '1.80', '74.0', '8', '135'),
       ('37', 'Hiroshi', 'Tanaka', '1984-06-06', '2002-02-20', '30000.0', 'Japón', 'Jugador', '', 'Portero', '21', '1.84', '79.0', '0', '160'),
       ('38', 'Marco', 'Rossi', '1983-12-12', '2001-04-04', '34000.0', 'Italia', 'Jugador', '', 'Delantero', '15', '1.81', '76.0', '48', '145'),
       ('39', 'Elena', 'Garcia', '1986-08-08', '2003-01-01', '32000.0', 'España', 'Jugador', '', 'Centrocampista', '16', '1.72', '67.0', '19', '120'),
       ('40', 'Pedro', 'Silva', '1984-11-11', '2002-06-06', '31000.0', 'Portugal', 'Jugador', '', 'Defensa', '17', '1.86', '77.0', '9', '155');