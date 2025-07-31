import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import org.acad.domain.model.User
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentPhoneBinding
import org.acad.presentation.screens.phone.PhoneVM
import org.acad.presentation.screens.phone.PhoneVM.Effect
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Acad Bek on 7/30/2025
 */

class PhoneFragment : BaseFragment<FragmentPhoneBinding>(FragmentPhoneBinding::inflate) {
    private val vm: PhoneVM by viewModel()

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.state.observe(::renderUser) { it.user as User }
        vm.effects.doOnNext(::handleEffect)
    }

    private fun renderUser(user: User?) {}

    private fun handleEffect(effect: Effect) {}
}