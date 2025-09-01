package org.acad.presentation.screens.main

import android.annotation.SuppressLint
import com.github.terrakok.cicerone.Router
import org.acad.domain.usecases.settings.GetOnboarded
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigation.Screens.onboardingScreen
import org.acad.presentation.navigation.Screens.phoneScreen
import org.acad.presentation.screens.main.MainVM.Effect
import org.acad.presentation.screens.main.MainVM.Event
import org.acad.presentation.screens.main.MainVM.State

/**
 * Created by Acad Bek on 7/31/2025
 */
class MainVM(
    private val router: Router, private val getOnboardedUseCase: GetOnboarded
) : BaseVM<State, Event, Effect>() {

    class State
    class Event
    class Effect

    init {
        getOnboarded()
    }

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {}

    @SuppressLint("CheckResult")
    private fun getOnboarded() {
        getOnboardedUseCase().subscribe { onboarded ->
            router.newRootScreen(
                if (onboarded) phoneScreen() else onboardingScreen()
            )
        }
    }
}