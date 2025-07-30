package org.acad.domain.repo

/**
 * Created by Acad Bek on 7/30/2025
 */
interface AuthRepo {
    fun sentSmsCode(phone: String)
}