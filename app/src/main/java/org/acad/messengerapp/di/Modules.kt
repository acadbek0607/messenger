package org.acad.messengerapp.di

import com.github.terrakok.cicerone.Cicerone
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.acad.data.local.settings.SettingsRealm
import org.acad.data.local.settings.SettingsRepoImpl
import org.acad.data.local.settings.SettingsStorage
import org.acad.data.local.settings.SettingsStorageImpl
import org.acad.data.local.user.UserStorage
import org.acad.data.local.user.UserStorageImpl
import org.acad.data.remote.auth.AuthFirebase
import org.acad.data.remote.auth.AuthFirebaseImpl
import org.acad.data.remote.repo.AuthRepoImpl
import org.acad.domain.repo.AuthRepo
import org.acad.domain.repo.SettingsRepo
import org.acad.domain.usecases.auth.SendSmsCode
import org.acad.domain.usecases.settings.GetOnboarded
import org.acad.domain.usecases.settings.Onboarded
import org.acad.presentation.screens.main.MainVM
import org.acad.presentation.screens.onboarding.OnboardingVM
import org.acad.presentation.screens.phone.PhoneVM
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Created by Acad Bek on 7/31/2025
 */

private val cicerone = Cicerone.create()

val config = RealmConfiguration.Builder(schema = setOf(SettingsRealm::class)).build()

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
    single { SendSmsCode(get()) }
    single { Onboarded(get()) }
    single { GetOnboarded(get()) }
}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
    single<SettingsStorage> { SettingsStorageImpl(get()) }
}

val remoteModule = module {
    single<AuthFirebase> { AuthFirebaseImpl() }
}

val vmModule = module {
    viewModelOf (::PhoneVM)
    viewModelOf (::MainVM)
    viewModelOf (::OnboardingVM)
}