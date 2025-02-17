package org.acad.data.store.settings

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

/**
 * Created by Acad Bek on 2/17/2025
 */
interface SettingsStorage {
    fun onboarded(): Completable
    fun getOnBoarded(): Single<Boolean>
}