package dev.alejandrozaragoza.proyectofinal.Equipo.exception

sealed class PersonasException(message: String): Exception(message) {
    class PersonasNotFoundException(id: String): PersonasException("Persona no encontrada con id: $id")
    class PersonasStorageException(message: String): PersonasException("Error en el almacenar: $message")
    class PersonasValidationException(message: String): PersonasException("Error en la validación: $message")
}