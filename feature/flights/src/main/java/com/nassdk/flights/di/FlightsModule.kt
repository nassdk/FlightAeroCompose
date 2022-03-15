package com.nassdk.flights.di

import com.nassdk.common.base.BaseMapper
import com.nassdk.di.scopes.FeatureScope
import com.nassdk.flights.FlightsApi
import com.nassdk.flights.FlightsApiImpl
import com.nassdk.flights.data.db.FavoritesDataSource
import com.nassdk.flights.data.db.FavoritesDataSourceImpl
import com.nassdk.flights.data.db.dto.FlightLocalDto
import com.nassdk.flights.data.mapper.FavoritesMapper
import com.nassdk.flights.data.mapper.FavoritesToDtoMapper
import com.nassdk.flights.data.mapper.RTFlightsResponseMapper
import com.nassdk.flights.data.network.dto.RTFlightsResponseDto
import com.nassdk.flights.data.repo.FlightsRepositoryImpl
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.domain.entity.RTFlightsEntity
import com.nassdk.flights.domain.repo.FlightsRepository
import com.nassdk.flights.presentation.list.ui.FlightsUiBuilder
import com.nassdk.flights.presentation.list.ui.FlightsUiBuilderImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
internal interface FlightsModule {

    @Binds
    @FeatureScope
    fun bindModuleApi(impl: FlightsApiImpl): FlightsApi

    @Binds
    @Reusable
    fun bindRepository(impl: FlightsRepositoryImpl): FlightsRepository

    @Binds
    @Reusable
    fun bindMapper(impl: RTFlightsResponseMapper): BaseMapper<RTFlightsResponseDto, RTFlightsEntity>

    @Binds
    @Reusable
    fun bindFavoritesDataSource(impl: FavoritesDataSourceImpl): FavoritesDataSource

    @Binds
    @Reusable
    fun bindFavoritesMapper(impl: FavoritesMapper): BaseMapper<FlightLocalDto, FlightEntity>

    @Binds
    @Reusable
    fun bindFavoritesToDtoMapper(impl: FavoritesToDtoMapper): BaseMapper<FlightEntity, FlightLocalDto>

    @Binds
    fun bindFlightsUiBuilder(impl: FlightsUiBuilderImpl): FlightsUiBuilder
}