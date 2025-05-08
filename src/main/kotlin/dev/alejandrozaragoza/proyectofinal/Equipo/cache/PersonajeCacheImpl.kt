package dev.alejandrozaragoza.proyectofinal.Equipo.cache

import org.lighthousegames.logging.logging


class PersonajeCacheImpl<K, V>(private val capacity: Int = 5): PersonajeCache<K, V> {
    private val logger = logging()

    private val cache = object : LinkedHashMap<K, V>(
        capacity, 0.75f,
    ) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
            logger.debug { "Alcanzando el tamaño máximo" }
            return size > capacity
        }
    }

    override fun get(key: K): V? {
        logger.debug { "Obteniendo elementos de la cache con clase: $key" }
        return cache[key]
    }

    override fun put(key: K, value: V): V? {
        logger.debug { "Guardando elementos en la cache con clave: $key" }
        cache[key] = value
        return value
    }

    override fun remove(key: K): V? {
        logger.debug { "Borrando elementos de la cache con clave: $key" }
        return cache.remove(key)
    }

    override fun clear() {
        logger.debug { "Limpiando cache" }
        cache.clear()
    }

    override fun size(): Int {
        logger.debug { "Obteniendo tamaño de la cache" }
        return cache.size
    }

    override fun keys(): Set<K> {
        logger.debug { "Obteniendo clave de la cache" }
        return cache.keys
    }

    override fun values(): Collection<V> {
        logger.debug { "Obteniendo valores de la cache" }
        return cache.values
    }

    override fun entries(): Set<Map.Entry<K, V>> {
        logger.debug { "Obteniendo entradas de la cache" }
        return cache.entries
    }
}