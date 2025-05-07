package dev.alejandrozaragoza.proyectofinal.Equipo.error

sealed class PersonasError(val message: String) {
    class LoadJson(message: String) : PersonasError(message)
    class SaveJson(message: String) : PersonasError(message)

    class LoadCsv(message: String) : PersonasError(message)
    class SaveCsv(message: String) : PersonasError(message)

    class LoadBin(message: String) : PersonasError(message)
    class SaveBin(message: String) : PersonasError(message)

    class LoadXml(message: String) : PersonasError(message)
    class SaveXml(message: String) : PersonasError(message)

    class PersonasStorageException(message: String) : PersonasError(message)
}
