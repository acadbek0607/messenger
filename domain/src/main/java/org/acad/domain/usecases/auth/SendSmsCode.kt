package org.acad.domain.usecases.auth

import org.acad.domain.repo.AuthRepo

/**
 * Created by Acad Bek on 7/30/2025
 */
class SendSmsCode (
    private val authRepo: AuthRepo
) {
    operator fun invoke(phone: String) {
        authRepo.sentSmsCode(phone)
    }
}