package dev.alejandrozaragoza.proyectofinal.Equipo.dao

import org.jdbi.v3.sqlobject.customizer.Bind
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

interface PersonasDao {
    @SqlQuery("SELECT * FROM persona")
    fun getAll(): List<PersonasEntity>

    @SqlQuery("SELECT * FROM persona WHERE id = :id")
    fun getById(@Bind("id") id: Long): PersonasEntity?

    @SqlUpdate("DELETE FROM alumnos")
    fun deleteAll()

    @SqlUpdate("""
    INSERT INTO Personas (
        nombre, apellidos, fecha_nacimiento, fecha_incorporacion, salario, pais, rol,
        especialidad, posicion, dorsal, altura, peso, goles, partidos_jugados, created_at, updated_at
    ) VALUES (
        :nombre, :apellidos, :fechaNacimiento, :fechaIncorporacion, :salario, :pais, :rol,
        :especialidad, :posicion, :dorsal, :altura, :peso, :goles, :partidosJugados, :createdAt, :updatedAt
    )
""")
    @GetGeneratedKeys("id")
    fun save(@BindBean persona: PersonasEntity): Int

    @GetGeneratedKeys("id")
    fun insert(@Bind persona: PersonasEntity): Int

    @GetGeneratedKeys("id")
    fun delete(@Bind("id") id: Long): Int


    @SqlUpdate("""
    UPDATE Personas SET 
        nombre = :nombre,
        apellidos = :apellidos,
        fecha_nacimiento = :fechaNacimiento,
        fecha_incorporacion = :fechaIncorporacion,
        salario = :salario,
        pais = :pais,
        rol = :rol,
        especialidad = :especialidad,
        posicion = :posicion,
        dorsal = :dorsal,
        altura = :altura,
        peso = :peso,
        goles = :goles,
        partidos_jugados = :partidosJugados,
        updated_at = :updatedAt
    WHERE id = :id
""")
    fun update(@BindBean persona: PersonasEntity): Int

    @SqlUpdate("DELETE FROM Personas WHERE id = :id")
    fun deleteById(@Bind("id") id: Long): Int



}