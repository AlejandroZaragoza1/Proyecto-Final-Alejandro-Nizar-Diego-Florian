package dev.alejandrozaragoza.proyectofinal.Equipo.database


import dev.alejandrozaragoza.proyectofinal.Equipo.config.Config
import org.apache.ibatis.jdbc.ScriptRunner
import org.lighthousegames.logging.logging
import java.io.PrintWriter
import java.io.Reader
import java.sql.Connection
import java.sql.DriverManager

object DataBaseManager: AutoCloseable {
    private val logger = logging()

    var connection: Connection? = null
        private set

    init {
        initDatabase()
    }

    private fun initDatabase() {
        initConexion()
        if (Config.databaseInitTables) {
            initTables()
        }
        if (Config.databaseInitData){
            initData()
        }
        close()
    }

    private fun initData() {
        logger.debug { "Iniciando carga de datos" }
        try {
            val data = ClassLoader.getSystemResourceAsStream("data.sql")?.bufferedReader()!!
            scriptRunner(data, true)
            logger.debug { "Datos cargados" }
        } catch (e: Exception) {
            logger.error { "Error al cargar los datos: ${e.message}" }
        }
    }

    private fun scriptRunner(reader: Reader, logWriter: Boolean = false) {
        logger.debug { "Ejecutando script SQL con log: $logWriter" }
        val sr = ScriptRunner(connection)
        sr.setLogWriter(if (logWriter) PrintWriter(System.out) else null)
        sr.runScript(reader)
    }

    private fun initTables() {
        logger.debug { "Creando tablas" }
        try {
            val tablas =  ClassLoader.getSystemClassLoader().getResourceAsStream("tables.sql")?.bufferedReader()!!
            scriptRunner(tablas, true)
            logger.debug { "Tablas de estudiantes creada" }
        } catch (e: Exception) {
            logger.error { "Error al crear las tablas: ${e.message}" }
        }
    }

    private fun initConexion() {
        logger.debug { "Iniciando conexión con la base de datos en ${Config.databaseUrl}" }
        logger.debug { "Iniciando conexión con la base de datos" }
        if (connection == null || connection!!.isClosed) {
            connection = DriverManager.getConnection(Config.databaseUrl)
        }
        logger.debug { "Conexión con la base de datos inicializada" }
    }

    override fun close() {
        logger.debug { "Cerrando conexión con la base de datos" }
        if (!connection!!.isClosed) {
            connection!!.close()
        }
        logger.debug { "Conexión con la base de datos cerrada" }
    }

    fun <T> use(block: (DataBaseManager) -> T) {
        initConexion()
        this.connection.use { block(this) }
        close()
    }
}