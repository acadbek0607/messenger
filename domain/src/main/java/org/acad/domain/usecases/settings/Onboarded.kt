package org.acad.domain.usecases.settings

import org.acad.domain.repo.SettingsRepo

/**
 * Created by Acad Bek on 8/1/2025
 */
class Onboarded(
    private val settingsRepo: SettingsRepo
) {
    operator fun invoke() = settingsRepo.onboarded()
}