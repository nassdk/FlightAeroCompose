package com.nassdk.common.base

import io.realm.Realm
import io.realm.RealmModel
import io.realm.kotlin.executeTransactionAwait

abstract class BaseLocalStorage {

    suspend fun <T : RealmModel> add(vararg realmObject: T) {
        Realm.getDefaultInstance().use { db ->
            db.executeTransactionAwait { realm ->
                realmObject.forEach { model ->
                    realm.insert(model)
                }
            }
        }
    }

    suspend fun <T : RealmModel> remove(realmObject: Class<T>) {
        Realm.getDefaultInstance().use { db ->
            db.executeTransactionAwait { realm ->
                realm.delete(realmObject)
            }
        }
    }

    suspend fun <T : RealmModel> retrieveAll(realmObject: Class<T>): List<T> {

        Realm.getDefaultInstance().use { db ->
            return db.where(realmObject).findAll()
        }
    }

    suspend fun <T : RealmModel> clear() {

        Realm.getDefaultInstance().use { db ->
            db.executeTransactionAwait { realm ->
                realm.deleteAll()
            }
        }
    }
}