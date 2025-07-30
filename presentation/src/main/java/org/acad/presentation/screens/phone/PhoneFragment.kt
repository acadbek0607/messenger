import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentPhoneBinding
import org.acad.presentation.screens.phone.PhoneVM
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Acad Bek on 7/30/2025
 */

class PhoneFragment : BaseFragment<FragmentPhoneBinding>(FragmentPhoneBinding::inflate) {
    private val vm: PhoneVM by viewModel()
}