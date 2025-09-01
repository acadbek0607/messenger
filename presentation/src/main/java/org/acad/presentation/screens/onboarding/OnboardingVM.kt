package org.acad.presentation.screens.onboarding

import android.annotation.SuppressLint
import com.github.terrakok.cicerone.Router
import org.acad.domain.usecases.settings.Onboarded
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigation.Screens.phoneScreen
import org.acad.presentation.screens.onboarding.OnboardingVM.*

/**
 * Created by Acad Bek on 9/1/2025
 */
class OnboardingVM(
    private val onboardedUseCase: Onboarded,
    private val router: Router
) : BaseVM<State, Event, Effect>() {

    class State
    sealed class Event {
        object Onboarded : Event()
    }
    class Effect


    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {
        when(event) {
            Event.Onboarded -> onboarded()
        }
    }

    @SuppressLint("CheckResult")
    private fun onboarded() {
        onboardedUseCase().subscribe {
            router.replaceScreen(phoneScreen())
        }
    }
}