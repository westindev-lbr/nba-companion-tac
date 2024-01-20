package com.tac.nba_companion.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tac.nba_companion.core.util.Constants.Companion.BASE_URL
import com.tac.nba_companion.data.remote.EspnNbaApi
import com.tac.nba_companion.data.remote.dto.team.TeamDtoMapper
import com.tac.nba_companion.data.repository.TeamRepositoryImpl
import com.tac.nba_companion.domain.repository.ITeamRepository
import com.tac.nba_companion.domain.usecases.GetAllTeamsUseCase
import com.tac.nba_companion.presentation.common.ErrorTypeToErrorTextConverterImpl
import com.tac.nba_companion.presentation.common.IErrorTypeToErrorTextConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideApiInstance(): EspnNbaApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EspnNbaApi::class.java)
    }


    @Singleton
    @Provides
    fun provideTeamDtoMapper(): TeamDtoMapper {
        return TeamDtoMapper()
    }

    @Singleton
    @Provides
    fun provideTeamRepository(
        api: EspnNbaApi,
        teamDtoMapper: TeamDtoMapper,
    ) = TeamRepositoryImpl(api, teamDtoMapper) as ITeamRepository


    @Provides
    fun provideGetAllTeamsUseCase(teamRepository: ITeamRepository): GetAllTeamsUseCase {
        return GetAllTeamsUseCase(teamRepository)
    }

    @Singleton
    @Provides
    fun provideErrorTypeToErrorTextConverter() : IErrorTypeToErrorTextConverter {
        return ErrorTypeToErrorTextConverterImpl()
    }

}