package dev.alejandrozaragoza.proyectofinal.Equipo.validator

import dev.alejandrozaragoza.proyectofinal.Equipo.exception.PersonasException
import org.example.proyectojugadores.Equipo.models.Jugador
import org.example.proyectojugadores.Equipo.models.Personas
import org.lighthousegames.logging.logging


class PersonasValidator{
    private val logger = logging()

    fun validatorPer(personas: Personas) {
        logger.debug { "Validando persona" }
        if (personas.nombre.isBlank()) {
            throw PersonasException.PersonasValidationException("El nombre no puede estar en blanco")
        }
        if (personas.apellido.isBlank()) {
            throw PersonasException.PersonasValidationException("El apellido no puede estar en blanco")
        }
        if (personas.salario <= 0){
            throw PersonasException.PersonasValidationException("El salario no puede ser inferior o igual de 0")
        }
        if (personas.pais.isBlank()) {
            throw PersonasException.PersonasValidationException("El pais no puede estar en blanco")
        }
    }
    fun validatorPer(jugador: Jugador) {
        logger.debug { "Validando jugador" }
        if (jugador.dorsal!! in 99..1){
            throw PersonasException.PersonasValidationException("El dorsal no puede ser superior a 99 ni inferior a 1")
        }
        if (jugador.goles!! < 0){
            throw PersonasException.PersonasValidationException("Los goles no pueden ser negativos")
        }
        if (jugador.partidos!! < 0){
            throw PersonasException.PersonasValidationException("Los partidos no pueden ser negativos")
        }
    }
}