package org.acad.domain.repo

/**
 * Created by Acad Bek on 2/15/2025
 */
interface AuthRepo {
    fun sendSmsCode(phone: String)
}