package com.tac.nba_companion.data.remote.dto.teamdetail

import com.google.gson.annotations.SerializedName
import com.tac.nba_companion.data.remote.response.FranchiseObject

data class TeamDetailDTO(
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
    @SerializedName("color")
    val color: String,
    @SerializedName("alternateColor")
    val altColor: String,
    @SerializedName("standingSummary")
    val currentRank: String,
    @SerializedName("franchise")
    val franchise: FranchiseObject,
)

data class Logo(
    val href: String,
    val alt: String?,
    val rel: List<String>,
    val width: Int,
    val height: Int
)




