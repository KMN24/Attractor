package kg.attractor.ui.profile

import android.view.LayoutInflater
import kg.attractor.databinding.FragmentProfileBinding
import kg.attractor.ui.utils.base.BaseVMFragment
import kg.attractor.vm.profile.ProfileVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment: BaseVMFragment<FragmentProfileBinding, ProfileVM>() {
    override val viewModel: ProfileVM by viewModel()

    override fun inflateBinding(inflater: LayoutInflater): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater)
    }

    override fun init() {

    }
}