package org.actorlang.interpreter.comms

class Message(
    val args: Array<Any>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Message

        if (!args.contentEquals(other.args)) return false

        return true
    }

    override fun hashCode(): Int {
        return args.contentHashCode()
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("[")
        args.forEachIndexed { i, v ->
            if (v is String) {
                sb.append("\"$v\"")
            } else {
                sb.append(v)
            }
            if (i < args.size - 1) {
                sb.append(", ")
            }
        }
        sb.append("]")
        return sb.toString()
    }
}
