package org.acad.presentation.screens.onboarding

import android.os.Bundle
import android.view.View
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentOnboardingBinding
import org.acad.presentation.screens.onboarding.OnboardingVM.Event
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Acad Bek on 9/1/2025
 */
class OnboardingFragment :
    BaseFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {

    private val vm: OnboardingVM by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() = with(binding) {
        next.setOnClickListener {
            vm.processEvent(Event.Onboarded)
        }
    }
}