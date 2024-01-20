package com.tac.nba_companion.data.remote.dto.team

import com.google.gson.annotations.SerializedName

data class TeamDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("displayName")
    val name: String,

    @SerializedName("abbreviation")
    val abbreviation: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("logos")
    val logos: List<Logo>,

    )

data class Logo(
    val href: String,
    val alt: String?,
    val rel: List<String>,
    val width: Int,
    val height: Int
)
