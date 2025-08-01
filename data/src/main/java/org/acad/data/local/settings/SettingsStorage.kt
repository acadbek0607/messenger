package org.acad.data.local.settings

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

/**
 * Created by Acad Bek on 8/1/2025
 */
interface SettingsStorage {
    fun onboarded() : Completable
    fun getOnboarded() : Single<Boolean>
}