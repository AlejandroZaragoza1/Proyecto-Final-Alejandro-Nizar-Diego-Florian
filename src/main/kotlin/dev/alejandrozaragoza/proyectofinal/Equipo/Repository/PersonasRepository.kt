package dev.alejandrozaragoza.proyectofinal.Equipo.Repository

import org.example.proyectojugadores.Equipo.models.Personas

interface PersonasRepository {
    fun findAll(): List<Personas>
    fun findById(id: Long): Personas?
    fun save(persona: Personas): Personas
    fun deleteById(id: Long)
    fun deleteAll()
    fun saveAll(persona: List<Personas>): List<Personas>
}