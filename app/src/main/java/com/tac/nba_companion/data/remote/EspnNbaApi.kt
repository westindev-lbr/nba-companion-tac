package com.tac.nba_companion.data.remote

import com.tac.nba_companion.data.remote.response.SportsData
import com.tac.nba_companion.data.remote.response.TeamDetailObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EspnNbaApi {

    /**
     * Retrofit
     * @GET : permet de déclencher une requête GET au endpoint BASE_URL/teams.
     * Retourne un objet SportsData encapsulé par une "Response" (objet Retrofit)
     */
    @GET("teams")
    suspend fun fetchTeamsData(): Response<SportsData>

    @GET("teams/{id}")
    suspend fun fetchTeam(@Path("id") id:String): Response<TeamDetailObject>
}