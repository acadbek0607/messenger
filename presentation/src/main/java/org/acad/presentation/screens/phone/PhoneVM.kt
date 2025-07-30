package org.acad.presentation.screens.phone

import org.acad.domain.model.User
import org.acad.domain.usecases.auth.SendSmsCode
import org.acad.presentation.base.BaseVM
import org.acad.presentation.screens.phone.PhoneVM.*

/**
 * Created by Acad Bek on 7/30/2025
 */
class PhoneVM constructor(
    private val sendSmsCode: SendSmsCode
) : BaseVM<State, Event, Effect>() {

    data class State(
        val user: User? = null
    )

    class Event

    class Effect

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {}
}