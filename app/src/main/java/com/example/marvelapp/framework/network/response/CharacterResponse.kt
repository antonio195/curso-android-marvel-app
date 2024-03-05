package com.example.marvelapp.framework.network.response

import com.antoniocostadossantos.core.domain.model.Character

data class CharacterResponse(
    val id: String,
    val name: String,
    val thumbnailResponse: ThumbnailResponse
)

fun CharacterResponse.toCharacterModel(): Character {
    return Character(
        name = this.name,
        image = "${this.thumbnailResponse.path}.${this.thumbnailResponse.extension}"
    )
}
