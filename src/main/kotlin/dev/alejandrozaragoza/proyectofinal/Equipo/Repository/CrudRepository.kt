package dev.alejandrozaragoza.proyectofinal.Equipo.Repository

import org.example.proyectojugadores.Equipo.models.Personas

interface CrudRepository<ID, T> {
    fun getAll(): List<T>
    fun getById(id: ID): T?
    fun save(entidad: Personas): T
    fun update(id: ID, entidad: T): T?
    fun delete(id: ID): T?
    fun deleteById(id: ID)
    fun deleteAll()
}