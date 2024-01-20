package com.tac.nba_companion.data.remote.response

import com.google.gson.annotations.SerializedName
import com.tac.nba_companion.data.remote.dto.teamdetail.TeamDetailDTO

data class TeamDetailObject(
    @SerializedName("team")
    val team: TeamDetailDTO
)

data class FranchiseObject(
    @SerializedName("venue")
    val venue: VenueObject
)

data class VenueObject(
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("address")
    val address: Address,
    @SerializedName("images")
    val images: List<StadiumImg>
)


data class Address(
    val city: String,
    val state: String,
)

data class StadiumImg(
    val href: String,
    val width: Int,
    val height: Int,
    val alt: String?,
    val rel: List<String>
)