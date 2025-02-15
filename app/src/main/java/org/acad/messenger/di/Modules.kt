package org.acad.messenger.di

import org.acad.data.api.auth.AuthFirebase
import org.acad.data.api.auth.AuthFirebaseImpl
import org.acad.data.repo.AuthRepoImpl
import org.acad.data.store.user.UserStorage
import org.acad.data.store.user.UserStorageImpl
import org.acad.domain.repo.AuthRepo
import org.acad.domain.usecase.auth.SendSmsCodeUseCase
import org.acad.presentation.screens.phone.PhoneVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Acad Bek on 2/15/2025
 */

val repoModule = module {
    single<AuthRepo> { AuthRepoImpl(get()) }
}

val useCaseModule = module {
    single { SendSmsCodeUseCase(get()) }
}

val storeModule = module {
    single<UserStorage> { UserStorageImpl() }
}

val apiModule = module {
    single<AuthFirebase> { AuthFirebaseImpl() }
}

val vmModule = module {
    viewModel { PhoneVM(get()) }
}