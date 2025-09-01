package org.acad.data.local.settings

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query

/**
 * Created by Acad Bek on 8/1/2025
 */
class SettingsStorageImpl(
    private val realm: Realm
) : SettingsStorage {

    private fun getSettings(): Single<SettingsRealm> = Single.fromCallable {
        realm.query<SettingsRealm>().find().firstOrNull() ?: run {
            realm.writeBlocking {
                copyToRealm(SettingsRealm())
            }
        }
    }

    override fun onboarded(): Completable = Completable.fromCallable {
        realm.writeBlocking {
            query<SettingsRealm>().find().firstOrNull()?.onboarded = true
        }
    }


    override fun getOnboarded(): Single<Boolean> = getSettings().map { it.onboarded }
}