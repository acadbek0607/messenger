package org.acad.presentation.screens.main

import com.github.terrakok.cicerone.Router
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigation.Screens.phone
import org.acad.presentation.screens.main.MainVM.*

/**
 * Created by Acad Bek on 7/31/2025
 */
class MainVM (
    private val router: Router
) : BaseVM<State, Event, Effect>() {

    class State
    class Event
    class Effect

    init {
        router.newRootScreen(phone())
    }

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {}
}