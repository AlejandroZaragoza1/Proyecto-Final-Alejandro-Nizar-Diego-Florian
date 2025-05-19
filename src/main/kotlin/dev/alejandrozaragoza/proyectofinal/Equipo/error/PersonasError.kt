package dev.alejandrozaragoza.proyectofinal.Equipo.error

sealed class PersonasError(val message: String) {
    class PersonasStorageException(message: String) : PersonasError(message)
    class NotFound(s: String) : PersonasError("Persona no encontrada") {

    }
}


