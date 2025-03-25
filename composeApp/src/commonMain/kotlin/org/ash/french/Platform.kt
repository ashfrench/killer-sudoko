package org.ash.french

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
