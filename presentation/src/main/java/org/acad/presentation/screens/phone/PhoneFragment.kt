package org.acad.presentation.screens.phone

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import org.acad.domain.model.User
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentPhoneBinding
import org.acad.presentation.screens.phone.PhoneVM.Effect

/**
 * Created by Acad Bek on 2/15/2025
 */
class PhoneFragment : BaseFragment<FragmentPhoneBinding>(FragmentPhoneBinding::inflate) {

    private lateinit var vm: PhoneVM

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.state.observe(::renderUser) { it.user!! }
        vm.effects.doOnNext(::handleEffect)

    }

    private fun renderUser(user: User?) {}
    private fun handleEffect(effect: Effect) {}
}