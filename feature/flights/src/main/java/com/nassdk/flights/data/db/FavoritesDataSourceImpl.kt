package com.nassdk.flights.data.db

import com.nassdk.common.base.BaseLocalStorage
import com.nassdk.flights.data.db.dto.FlightLocalDto
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import javax.inject.Inject


internal class FavoritesDataSourceImpl @Inject constructor() : FavoritesDataSource, BaseLocalStorage() {

    override suspend fun addToFavorites(dto: FlightLocalDto) = add(dto)

    override fun isFlightFavorite(number: String): Boolean {

        Realm.getDefaultInstance().use { realm ->

            return realm.where(FlightLocalDto::class.java)
                .equalTo("number", number)
                .findFirst() != null
        }
    }

    override suspend fun removeFromFavorites(dto: FlightLocalDto) {

        Realm.getDefaultInstance().use { db ->
            db.executeTransactionAwait { realm ->
                realm.where(dto::class.java)
                    .equalTo("number", dto.number)
                    .findAll()
                    .deleteAllFromRealm()
            }
        }
    }

    override suspend fun getFavorites(): List<FlightLocalDto> {
        return retrieveAll(realmObject = FlightLocalDto::class.java)
    }
}