package org.acad.messenger.di

import com.github.terrakok.cicerone.Cicerone
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.acad.data.api.auth.AuthFirebase
import org.acad.data.api.auth.AuthFirebaseImpl
import org.acad.data.repo.AuthRepoImpl
import org.acad.data.repo.SettingsRepoImpl
import org.acad.data.store.settings.SettingsRealm
import org.acad.data.store.settings.SettingsStorage
import org.acad.data.store.settings.SettingsStorageImpl
import org.acad.data.store.user.UserStorage
import org.acad.data.store.user.UserStorageImpl
import org.acad.domain.repo.AuthRepo
import org.acad.domain.repo.SettingsRepo
import org.acad.domain.usecase.auth.SendSmsCodeUseCase
import org.acad.domain.usecase.settings.GetOnboardedUseCase
import org.acad.domain.usecase.settings.OnboardedUseCase
import org.acad.presentation.screens.main.MainVM
import org.acad.presentation.screens.phone.PhoneVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Acad Bek on 2/15/2025
 */

private val cicerone = Cicerone.create()
private val config = RealmConfiguration.Builder(schema = setOf(SettingsRealm::class)).build()

val appModule = module {
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
    single { Realm.open(config) }
}

val repoModule = module {
    single<AuthRepo> { AuthRepoImpl(get()) }
    single<SettingsRepo> { SettingsRepoImpl(get()) }
}

val useCaseModule = module {
    single { SendSmsCodeUseCase(get()) }
    single { OnboardedUseCase(get()) }
    single { GetOnboardedUseCase(get()) }
}

val storeModule = module {
    single<UserStorage> { UserStorageImpl() }
    single<SettingsStorage> { SettingsStorageImpl(get()) }
}

val apiModule = module {
    single<AuthFirebase> { AuthFirebaseImpl() }
}

val vmModule = module {
    viewModel { PhoneVM(get()) }
    viewModel { MainVM(get()) }
}