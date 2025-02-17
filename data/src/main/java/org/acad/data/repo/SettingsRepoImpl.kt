package org.acad.data.repo

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.acad.data.store.settings.SettingsStorage
import org.acad.domain.repo.SettingsRepo

/**
 * Created by Acad Bek on 2/17/2025
 */
class SettingsRepoImpl(
    private val settingsStorage: SettingsStorage
) : SettingsRepo {
    override fun onboarded(): Completable = settingsStorage
        .onboarded()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun getOnBoarded(): Single<Boolean> = settingsStorage
        .getOnBoarded()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}