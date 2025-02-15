package org.acad.presentation.screens.phone

import androidx.lifecycle.ViewModel
import org.acad.domain.usecase.auth.SendSmsCodeUseCase

/**
 * Created by Acad Bek on 2/15/2025
 */
class PhoneVM constructor(
    private val sendSmsCodeUseCase: SendSmsCodeUseCase
) : ViewModel() {
}