package edu.rit.pokedexfinalproject.models

import android.graphics.drawable.Drawable

data class Pokemon (
        val name: String,
        val id: String,
        val location: String,
        val img: String,
        val description: String,
        val type: String
        )