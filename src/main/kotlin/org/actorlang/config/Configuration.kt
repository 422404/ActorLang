package org.actorlang.config

class Configuration {
    // Debug
    var debug = false

    // Latency
    var messageLatencyMaxMillis by 20L constrained { it >= 0f }

    // Messages duplication
    var messageDuplicates = false
    var duplicationChances by 0.10f constrained { it >= 0f }
    var duplicatesMaxCount by 2 constrained { it >= 0 }

    // Out of order receiving
    var outOfOrderMessages = false
    var outOfOrderChances by 0.50f constrained { it >= 0f }
}
