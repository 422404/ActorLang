package org.actorlang.config

import org.actorlang.config.exceptions.ConfigurationException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BaseConfigContraint<T: Any>(
    private var value: T,
    private val validator: (T)->Boolean
): ReadWriteProperty<Configuration, T> {
    override fun getValue(thisRef: Configuration, property: KProperty<*>): T {
        return value
    }

    override fun setValue(thisRef: Configuration, property: KProperty<*>, value: T) {
        if (!validator(value)) {
            throw ConfigurationException(
                "Configuration property '${property.name}' value does not " +
                        "satisfy its contraints")
        }
        this.value = value
    }
}

infix fun <T: Any> T.constrained(validator: (T)->Boolean) =
    BaseConfigContraint(this, validator)
