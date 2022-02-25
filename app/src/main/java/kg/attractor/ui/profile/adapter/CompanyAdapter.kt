package kg.attractor.ui.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import kg.attractor.databinding.ItemCompanyBinding
import kg.attractor.domain.entities.Company
import kg.attractor.ui.utils.base.BaseAdapter

class CompanyAdapter: BaseAdapter<Company, ItemCompanyBinding, CompanyVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyVH {
        return CompanyVH(ItemCompanyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}