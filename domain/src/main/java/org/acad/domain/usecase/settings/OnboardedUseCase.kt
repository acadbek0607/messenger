package org.acad.domain.usecase.settings

import org.acad.domain.repo.SettingsRepo

/**
 * Created by Acad Bek on 2/17/2025
 */
class OnboardedUseCase(
    private val settingsRepo: SettingsRepo
) {
    operator fun invoke() = settingsRepo.onboarded()
}