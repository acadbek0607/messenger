package org.acad.data.api.auth

/**
 * Created by Acad Bek on 2/15/2025
 */
interface AuthFirebase {
    fun sendSmsCode(phone: String)
}