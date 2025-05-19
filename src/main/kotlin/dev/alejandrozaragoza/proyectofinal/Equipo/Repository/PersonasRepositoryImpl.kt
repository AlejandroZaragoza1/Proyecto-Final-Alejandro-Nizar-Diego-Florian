package dev.alejandrozaragoza.proyectofinal.Equipo.Repository

import dev.alejandrozaragoza.proyectofinal.Equipo.dao.PersonasDao
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toEntity
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toModel
import org.example.proyectojugadores.Equipo.models.Personas
import org.lighthousegames.logging.logging
import java.time.LocalDateTime

private val logger = logging()
abstract class PersonasRepositoryImpl(
    private val dao: PersonasDao

): PersonasRepository {


 /*   override fun getAll(): List<Personas> {
        logger.debug { "Obteniendo todo el equipo" }
        return dao.getAll().toModel()
    }
*/
    override fun getById(id: Long): Personas? {
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
        logger.debug { "Persona actualizado: $toUpdate" }
        return toUpdate
    }

    private fun create(persona: Personas): Personas {
        logger.debug { "crear: $persona" }
        val timestamp = LocalDateTime.now()
        val toSave = persona.copy(createdAt = timestamp, updatedAt = timestamp)
        val id = dao.insert(toSave.toEntity())
        return toSave.copy(id = id.toLong())
    }
    override fun update(id: Long, item: Personas): Personas? {
        val existing = getById(id)
        if (existing != null) {
            val updated = item.copy(
                id = id,
                updatedAt = LocalDateTime.now()
            )
            dao.update(updated.toEntity())
            return updated
        }
        return null
    }
    override fun delete(id: Long): Personas? {
        logger.debug { "Eliminar persona con id: $id" }
        val persona = getById(id)
        val res = dao.delete(id)
        if (res == 0) {
            throw Exception("No se ha podido eliminar la persona con id: $id")
        }
        logger.debug { "Persona eliminada con id: $id" }
        return persona
    }

    override fun deleteAll() {
        logger.debug { "deleteAll" }
        return dao.deleteAll()
    }

    override fun deleteById(id: Long) {
        logger.debug { "deleteById: $id" }
        val res = dao.delete(id)
        logger.debug { "Nuestra consulta de borrado ha devuelto: $res" }
        if (res == 0) {
            throw Exception("No se ha podido eliminar la persona con id: $id")
        }
        logger.debug { "Persona eliminada con id: $id" }
    }


}
