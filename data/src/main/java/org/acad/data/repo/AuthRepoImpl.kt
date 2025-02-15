package org.acad.data.repo

import org.acad.data.api.auth.AuthFirebase
import org.acad.domain.repo.AuthRepo

/**
 * Created by Acad Bek on 2/15/2025
 */
class AuthRepoImpl constructor(
    private val authFirebase: AuthFirebase
) : AuthRepo {
    override fun sendSmsCode(phone: String) {
        authFirebase.sendSmsCode(phone)
    }
}