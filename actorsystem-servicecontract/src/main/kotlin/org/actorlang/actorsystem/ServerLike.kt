package org.actorlang.actorsystem

interface ServerLike {
    /**
     * Starts a server-like service.
     * An implementation of this method should be able to be called multiple times without errors.
     */
    fun start()

    /**
     * Shutdowns a server-like service.
     * An implementation of this method should be able to be called multiple times without errors.
     *
     * Waits at most [timeoutMillis] milliseconds before returning.
     * @param timeoutMillis The timeout in milliseconds
     */
    fun shutdown(timeoutMillis: Long)
}
