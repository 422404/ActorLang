package org.actorlang.actorsystem

inline fun <T : ServerLike> T.scoped(shutdownTimeoutMillis: Long, action: T.() -> Unit) {
    try {
        start()
        action()
    } finally {
        shutdown(shutdownTimeoutMillis)
    }
}
