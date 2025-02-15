package org.acad.presentation.screens.phone

import androidx.lifecycle.ViewModel
import org.acad.domain.model.User
import org.acad.domain.usecase.auth.SendSmsCodeUseCase
import org.acad.presentation.base.BaseVM
import org.acad.presentation.screens.phone.PhoneVM.*

/**
 * Created by Acad Bek on 2/15/2025
 */
class PhoneVM constructor(
    private val sendSmsCodeUseCase: SendSmsCodeUseCase
) : BaseVM<State, Event, Effect>() {

    data class State(
        val user: User? = null
    )

    class Event

    class Effect

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {}
}