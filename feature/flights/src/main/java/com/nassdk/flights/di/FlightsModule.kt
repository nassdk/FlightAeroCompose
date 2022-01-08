package com.nassdk.flights.di

import com.nassdk.common.base.BaseMapper
import com.nassdk.di.scopes.FeatureScope
import com.nassdk.flights.FlightsApi
import com.nassdk.flights.FlightsApiImpl
import com.nassdk.flights.data.mapper.RTFlightsResponseMapper
import com.nassdk.flights.data.network.dto.RTFlightsResponseDto
import com.nassdk.flights.data.repo.FlightsRepositoryImpl
import com.nassdk.flights.domain.entity.RTFlightsEntity
import com.nassdk.flights.domain.repo.FlightsRepository
import com.nassdk.flights.presentation.ui.FlightsUiBuilder
import com.nassdk.flights.presentation.ui.FlightsUiBuilderImpl
import dagger.Binds
import dagger.Module

@Module
internal interface FlightsModule {

    @Binds
    @FeatureScope
    fun bindModuleApi(impl: FlightsApiImpl): FlightsApi

    @Binds
    @FeatureScope
    fun bindRepository(impl: FlightsRepositoryImpl): FlightsRepository

    @Binds
    @FeatureScope
    fun bindMapper(impl: RTFlightsResponseMapper): BaseMapper<RTFlightsResponseDto, RTFlightsEntity>

    @Binds
    fun bindFlightsUiBuilder(impl: FlightsUiBuilderImpl): FlightsUiBuilder
}