package kg.attractor.ui.profile

import android.view.LayoutInflater
import kg.attractor.R
import kg.attractor.databinding.FragmentProfileBinding
import kg.attractor.domain.entities.Company
import kg.attractor.domain.entities.UserData
import kg.attractor.ui.profile.adapter.CompanyAdapter
import kg.attractor.ui.utils.base.BaseVMFragment
import kg.attractor.ui.utils.extensions.setImage
import kg.attractor.vm.profile.ProfileVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment: BaseVMFragment<FragmentProfileBinding, ProfileVM>() {
    override val viewModel: ProfileVM by viewModel()

    private val companyAdapter by lazy { CompanyAdapter() }

    override fun inflateBinding(inflater: LayoutInflater): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater)
    }

    override fun init() {
        initObservers()
        initRV()
        initRequests()
    }

    private fun initRequests() {
        viewModel.getUser()
    }

    private fun initRV() {
        binding.rvCompanies.adapter = companyAdapter
    }

    private fun initObservers() = with(viewModel) {
        user.observe(viewLifecycleOwner){
            setUpUser(it.user)
        }
    }

    private fun setUpUser(user: UserData) = with(binding) {
        tvFirstName.text = user.firstName
        tvLastName.text = user.secondName
        if (user.photo == null)
            ivUserPhoto.setImageResource(R.drawable.image_avatar)
        else ivUserPhoto.setImage(user.photo)

        tvEducation.text = getString(viewModel.getEducationByType(user.education))

        setUpCompanies(user.company)
    }

    private fun setUpCompanies(companies: List<Company>) {
        companyAdapter.setData(companies)
    }
}