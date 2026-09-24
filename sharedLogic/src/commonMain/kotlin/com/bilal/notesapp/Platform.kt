package com.bilal.notesapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform