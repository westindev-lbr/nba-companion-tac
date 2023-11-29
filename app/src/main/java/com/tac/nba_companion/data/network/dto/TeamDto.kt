package com.tac.nba_companion.data.network.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class TeamDto(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("logos")
    val logo: List<Logo>
)


@Serializable
data class Logo(
    val href: String,
    val alt: String?,
    val rel: List<String>,
    val width: Int,
    val height: Int
)