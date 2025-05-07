package dev.alejandrozaragoza.proyectofinal.Equipo.mapers

import org.example.proyectojugadores.Equipo.dto.PersonasBinDto
import org.example.proyectojugadores.Equipo.dto.PersonasCsvDto
import org.example.proyectojugadores.Equipo.dto.PersonasJsonDto
import org.example.proyectojugadores.Equipo.dto.PersonasXmlDto
import org.example.proyectojugadores.Equipo.models.Entrenador
import org.example.proyectojugadores.Equipo.models.Jugador
import java.time.LocalDate

fun Entrenador.toCsvDto(): PersonasCsvDto {
    return PersonasCsvDto(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
        especialidad = this.especialidad.toString(),
        rol = "Entrenador"


    )
}
fun Jugador.toCsvDto(): PersonasCsvDto {
    return PersonasCsvDto(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
        posicion = this.posicion.toString(),
        dorsal = this.dorsal,
        altura = this.altura,
        peso = this.peso,
        goles = this.goles,
        partidos = this.partidos,
        minutosJugados = this.minutosJugados,
        rol = "Jugador"
    )
}
fun Entrenador.toJsonDto(): PersonasJsonDto {
    return PersonasJsonDto(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
        especialidad = this.especialidad.toString(),
        rol = "Entrenador"
    )
}
fun Jugador.toJsonDto(): PersonasJsonDto {
    return PersonasJsonDto(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
        posicion = this.posicion.toString(),
        dorsal = this.dorsal,
        altura = this.altura,
        peso = this.peso,
        goles = this.goles,
        partidos = this.partidos,
        minutosJugados = this.minutosJugados,
        rol = "Jugador"
    )
}
fun PersonasJsonDto.toEntrenador(): Entrenador {
    val especialidad = if (this.especialidad.isNullOrEmpty()) {
        Entrenador.Especialidad.ENTRENADOR_PRINCIPAL
    } else {
        try {
            Entrenador.Especialidad.valueOf(this.especialidad.uppercase())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Especialidad no válida: ${this.especialidad}")
        }
    }

    return Entrenador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = LocalDate.parse(this.fechaNacimiento),
        fechaIncorporacion = LocalDate.parse(this.fechaIncorporacion),
        salario = this.salario,
        pais = this.pais,
        especialidad = especialidad,
    )
}

fun PersonasJsonDto.toJugador(): Jugador {
    return Jugador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = LocalDate.parse(this.fechaNacimiento),
        fechaIncorporacion = LocalDate.parse(this.fechaIncorporacion),
        salario = this.salario,
        pais = this.pais,
        posicion = Jugador.Posicion.valueOf(this.posicion?.uppercase() ?: "DESCONOCIDO"),
        dorsal = this.dorsal ?: 0,
        altura = this.altura ?: 0.0,
        peso = this.peso ?: 0.0,
        goles = this.goles ?: 0,
        partidos = this.partidos ?: 0,
        minutosJugados = this.minutosJugados ?: 0.0,
    )
}

fun Entrenador.toXmlDto(): PersonasXmlDto {
    return PersonasXmlDto(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
        especialidad = this.especialidad.toString(),
    )
}
fun Jugador.toXmlDto(): PersonasXmlDto {
    return PersonasXmlDto(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
        posicion = this.posicion.toString(),
        dorsal = this.dorsal.toString(),
        altura = this.altura.toString(),
        peso = this.peso.toString(),
        goles = this.goles.toString(),
        partidos = this.partidos.toString(),
        minutosJugados = this.minutosJugados.toString()
        )
}
fun PersonasCsvDto.toEntrenador(): Entrenador {
    val especialidad = if (this.especialidad.isNullOrEmpty()) {
        Entrenador.Especialidad.ENTRENADOR_PRINCIPAL
    } else {
        try {
            Entrenador.Especialidad.valueOf(this.especialidad.toString())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Especialización no válida: ${this.especialidad}")
        }
    }
    return Entrenador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = LocalDate.parse(this.fechaNacimiento),
        fechaIncorporacion = LocalDate.parse(this.fechaIncorporacion),
        salario = this.salario,
        pais = this.pais,
        especialidad = especialidad,
    )
}

fun PersonasCsvDto.toJugador(): Jugador {
    val posicion = if (this.posicion.isNullOrEmpty()) {
        Jugador.Posicion.NINGUNO
    } else {
        try {
            Jugador.Posicion.valueOf(this.posicion.uppercase())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Posición no válida: ${this.posicion}")
        }
    }

    return Jugador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = LocalDate.parse(this.fechaNacimiento),
        fechaIncorporacion = LocalDate.parse(this.fechaIncorporacion),
        salario = this.salario,
        pais = this.pais,
        posicion = posicion,
        dorsal = this.dorsal,
        altura = this.altura,
        peso = this.peso,
        goles = this.goles,
        partidos = this.partidos,
        minutosJugados = this.minutosJugados
    )
}
fun PersonasXmlDto.toEntrenador(): Entrenador {
    val especialidad = if (this.especialidad.isEmpty()) {
        Entrenador.Especialidad.ENTRENADOR_PRINCIPAL
    } else {
        try {
            Entrenador.Especialidad.valueOf(this.especialidad.uppercase())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Especialidad no válida: ${this.especialidad}")
        }
    }

    return Entrenador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = LocalDate.parse(this.fechaNacimiento),
        fechaIncorporacion = LocalDate.parse(this.fechaIncorporacion),
        salario = this.salario,
        pais = this.pais,
        especialidad = especialidad
    )
}
fun PersonasXmlDto.toJugador(): Jugador {
    val posicion = if (this.posicion.isEmpty()) {
        Jugador.Posicion.NINGUNO
    } else {
        try {
            Jugador.Posicion.valueOf(this.posicion.uppercase())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Posición no válida: ${this.posicion}")
        }
    }

    return Jugador(
        id = this.id,
        nombre = this.nombre, // ⚡ en tu clase Jugador es "nambre"
        apellido = this.apellido,
        fechaNacimiento = LocalDate.parse(this.fechaNacimiento),
        fechaIncorporacion = LocalDate.parse(this.fechaIncorporacion),
        salario = this.salario,
        pais = this.pais,
        posicion = posicion,
        dorsal = this.dorsal.toIntOrNull() ,
        altura = this.altura.toDoubleOrNull(),
        peso = this.peso.toDoubleOrNull(),
        goles = this.goles.toIntOrNull(),
        partidos = this.partidos.toIntOrNull(),
        minutosJugados = this.minutosJugados.toDoubleOrNull()
    )
}
fun Entrenador.toBinDto(): PersonasBinDto {
    return PersonasBinDto(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido, // ⚡ no "apellidos"
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
        posicion = "", // Entrenador no tiene posicion
        especialidad = this.especialidad?.toString()
    )
}
fun Jugador.toBinDto(): PersonasBinDto {
    return PersonasBinDto(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
        posicion = this.posicion?.toString() ?: "NINGUNO",
        dorsal = this.dorsal,
        altura = this.altura,
        peso = this.peso,
        goles = this.goles,
        partidos = this.partidos,
        minutosJugados = this.minutosJugados,
        especialidad = null
    )
}
fun PersonasBinDto.toEntrenador(): Entrenador {
    val especialidad = if (this.especialidad.isNullOrEmpty()) {
        Entrenador.Especialidad.ENTRENADOR_PRINCIPAL
    } else {
        try {
            Entrenador.Especialidad.valueOf(this.especialidad.uppercase())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Especialidad no válida: ${this.especialidad}")
        }
    }

    return Entrenador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = LocalDate.parse(this.fechaNacimiento),
        fechaIncorporacion = LocalDate.parse(this.fechaIncorporacion),
        salario = this.salario,
        pais = this.pais,
        especialidad = especialidad
    )
}
fun PersonasBinDto.toJugador(): Jugador {
    val posicion = if (this.posicion.isEmpty()) {
        Jugador.Posicion.NINGUNO
    } else {
        try {
            Jugador.Posicion.valueOf(this.posicion.uppercase())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Posición no válida: ${this.posicion}")
        }
    }

    return Jugador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = LocalDate.parse(this.fechaNacimiento),
        fechaIncorporacion = LocalDate.parse(this.fechaIncorporacion),
        salario = this.salario,
        pais = this.pais,
        posicion = posicion,
        dorsal = this.dorsal ?: 0,
        altura = this.altura ?: 0.0,
        peso = this.peso ?: 0.0,
        goles = this.goles ?: 0,
        partidos = this.partidos ?: 0,
        minutosJugados = this.minutosJugados ?: 0.0
    )
}










