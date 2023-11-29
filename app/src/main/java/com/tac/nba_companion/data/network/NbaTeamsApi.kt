package com.tac.nba_companion.data.network

import com.tac.nba_companion.data.network.response.SportsData
import com.tac.nba_companion.domain.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NbaTeamsApi {

    @GET("teams")
    suspend fun getTeamsData(): SportsData

    companion object {
        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Synchronized
        fun getInstance(): NbaTeamsApi {
            return retrofit.create(NbaTeamsApi::class.java)
        }
    }

}
