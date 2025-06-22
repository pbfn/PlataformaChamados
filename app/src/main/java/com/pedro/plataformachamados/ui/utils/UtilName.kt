package com.pedro.plataformachamados.ui.utils

fun getTwoInitialsAlways(name: String): String {
    val nomes = name.trim()
        .split("\\s+".toRegex())
        .filter { it.isNotBlank() }

    return if (nomes.size >= 2) {
        nomes.take(2).joinToString("") { it.first().uppercaseChar().toString() }
    } else {
        nomes.firstOrNull()?.take(2)?.uppercase() ?: ""
    }
}