package org.acad.messengerapp.di

import com.github.terrakok.cicerone.Cicerone
import org.acad.data.local.user.UserStorage
import org.acad.data.local.user.UserStorageImpl
import org.acad.data.remote.auth.AuthFirebase
import org.acad.data.remote.auth.AuthFirebaseImpl
import org.acad.data.remote.repo.AuthRepoImpl
import org.acad.domain.repo.AuthRepo
import org.acad.domain.usecases.auth.SendSmsCode
import org.acad.presentation.screens.main.MainVM
import org.acad.presentation.screens.phone.PhoneVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Acad Bek on 7/31/2025
 */

private val cicerone = Cicerone.create()

val appModule = module {
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
}

val repoModule = module {
    single<AuthRepo> { AuthRepoImpl(get()) }
}

val useCaseModule = module {
    single { SendSmsCode(get()) }
}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
}

val remoteModule = module {
    single<AuthFirebase> { AuthFirebaseImpl() }
}

val vmModule = module {
    viewModel { PhoneVM(get()) }
    viewModel { MainVM(get()) }
}