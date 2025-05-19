package dev.alejandrozaragoza.proyectofinal.Equipo.error

sealed class PersonasError(val message: String) {
    class PersonasNotFound(message: String): PersonasError(message)
    class PersonasStorageException(message: String) : PersonasError(message)
}


