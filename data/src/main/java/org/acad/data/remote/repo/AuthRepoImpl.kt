package org.acad.data.remote.repo

import org.acad.data.remote.auth.AuthFirebase
import org.acad.domain.repo.AuthRepo

/**
 * Created by Acad Bek on 7/30/2025
 */
class AuthRepoImpl constructor(
    private val authFirebase: AuthFirebase
) : AuthRepo  {
    override fun sentSmsCode(phone: String) {
        authFirebase.send(phone)
    }

}