package kg.attractor.ui.pictures.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.attractor.databinding.ItemImageBinding
import kg.attractor.ui.utils.extensions.setImage

class SelectImageAdapter(private val imageCancelable: ImageCancelable) :
    ListAdapter<String, SelectImageAdapter.ImageVH>(ImageDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
        return ImageVH(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
        holder.bind(getItem(position))
    }

    fun swapData(data: List<String>) {
        submitList(data)
    }

    inner class ImageVH(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.ivImage.setImage(item)

            binding.ivDelete.setOnClickListener {
                imageCancelable.deleteImage(adapterPosition)
            }
        }
    }

    private class ImageDiffUtil : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }
    }
}