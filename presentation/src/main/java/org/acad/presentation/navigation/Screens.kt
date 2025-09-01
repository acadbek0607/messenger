package org.acad.presentation.navigation

import PhoneFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.acad.presentation.screens.onboarding.OnboardingFragment

/**
 * Created by Acad Bek on 7/31/2025
 */
object Screens {
    fun phoneScreen() = FragmentScreen { PhoneFragment() }
    fun onboardingScreen() = FragmentScreen { OnboardingFragment() }
}