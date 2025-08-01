package org.acad.data.local.settings

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.acad.domain.repo.SettingsRepo

/**
 * Created by Acad Bek on 8/1/2025
 */
class SettingsRepoImpl(
    private val settingsStorage: SettingsStorage
) : SettingsRepo {

    override fun onboarded(): Completable = settingsStorage
        .onboarded()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun getOnboarded(): Single<Boolean> = settingsStorage
        .getOnboarded()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}