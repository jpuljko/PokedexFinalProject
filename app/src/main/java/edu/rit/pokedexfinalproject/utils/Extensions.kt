package edu.rit.pokedexfinalproject.utils

import android.content.Context

fun String.toDrawable(c: Context): Int {
    return c.resources.getIdentifier(this, "drawable", c.packageName)
}