package dev.alejandrozaragoza.proyectofinal.Equipo.Repository

import dev.alejandrozaragoza.proyectofinal.Equipo.dao.PersonasDao
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toModel
import org.example.proyectojugadores.Equipo.models.Personas
import org.lighthousegames.logging.logging
import java.time.LocalDate
import java.time.LocalDateTime

private val logger = logging()
abstract class PersonasRepositoryImpl(
    private val dao: PersonasDao
): PersonasRepository {

    override fun findAll(): List<Personas> {
        logger.debug { "Obteniendo todo el equipo" }
        return dao.getAll().toModel()
    }

    override fun findById(id: Long): Personas? {
        logger.debug { "Obtener persona de la plantilla con id: $id" }
        return dao.getById(id)?.toModel()
    }

    override fun save(persona: Personas): Personas {
        logger.debug { "Guardando persona" }
        return if (persona.isNewPersona){
            create(persona)
        } else {
            update(persona)
        }
    }

    private fun update(persona: Personas): Personas {
        logger.debug { "Actualizar: $persona" }
        val timestamp = LocalDateTime.now()
        val toUpdate = persona.copy(updatedAt = timestamp)
        val res = dao.update(toUpdate.toEntity())
        if (res == 0) {
            throw Exception("No se ha podido actualizar la persona: $persona")
        }
        logger.debug { "Nuestra consulta de actualización ha devuelto: $res" }
        logger.debug { "Persona actualizado: $toUpdate" }
        return toUpdate
    }

    private fun create(persona: Personas): Personas {
        logger.debug { "crear: $persona" }
        val timestamp = LocalDateTime.now()
        val toSave = persona.copy(createdAt = timestamp, updatedAt = timestamp)
        val id = dao.insert(toSave.toEntity())
        return toSave.copy(id = id)
    }

    override fun deleteById(id: Long) {
        logger.debug { "Eliminar persona con id: $id" }
        val res = dao.delete(id)
        if (res == 0){
            throw Exception("No se ha podido eliminar la persona con id: $id")
        }
        logger.debug { "Nuestra consulta de borrado ha devuelto: $res" }
        logger.debug { "Alumno eliminado con id: $id" }
    }

    override fun deleteAll() {
        logger.debug { "Eliminar todas las personas" }
        return dao.deleteAll()
    }

    override fun saveAll(persona: List<Personas>): List<Personas> {
        logger.debug { "Guardar todas las personas: $persona" }
        return persona.map { save(it) }
    }

}
