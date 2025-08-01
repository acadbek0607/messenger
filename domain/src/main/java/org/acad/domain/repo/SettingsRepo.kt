package org.acad.domain.repo

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

/**
 * Created by Acad Bek on 8/1/2025
 */
interface SettingsRepo {
    fun onboarded(): Completable
    fun getOnboarded(): Single<Boolean>
}