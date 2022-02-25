package kg.attractor.ui.profile.adapter

import kg.attractor.databinding.ItemCompanyBinding
import kg.attractor.domain.entities.Company
import kg.attractor.ui.utils.base.BaseVH

class CompanyVH(binding: ItemCompanyBinding): BaseVH<Company, ItemCompanyBinding>(binding) {
    override fun bind(item: Company) {
        binding.tvCompanyName.text = item.name
        binding.tvCompanyPosition.text = item.position
    }
}