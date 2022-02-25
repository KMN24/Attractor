package kg.attractor.ui.pictures

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import com.theartofdev.edmodo.cropper.CropImage
import kg.attractor.databinding.FragmentPicturesBinding
import kg.attractor.ui.pictures.adapter.ImageCancelable
import kg.attractor.ui.pictures.adapter.SelectImageAdapter
import kg.attractor.ui.utils.base.BaseVMFragment
import kg.attractor.ui.utils.extensions.pickImages
import kg.attractor.ui.utils.extensions.snackbar
import kg.attractor.vm.pictures.PicturesVM
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList

class PicturesFragment: BaseVMFragment<FragmentPicturesBinding, PicturesVM>(), ImageCancelable {
    override val viewModel: PicturesVM by viewModel()
    private val imageAdapter by lazy { SelectImageAdapter( this) }


    override fun inflateBinding(inflater: LayoutInflater): FragmentPicturesBinding {
        return FragmentPicturesBinding.inflate(inflater)
    }

    override fun init() {
        initRV()
        initListeners()
        initObservers()
    }

    private fun initRV() {
        binding.rvImages.adapter = imageAdapter
    }

    private fun initObservers() {
        viewModel.images.observe(viewLifecycleOwner){
            Log.e("images", "${ArrayList(it)}")
            imageAdapter.swapData(it)
        }
    }

    private fun initListeners() {
        binding.btnAddPhoto.setOnClickListener {
            pickImages()
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            if (data?.clipData != null) {
                val clipData = data.clipData
                val uris = ArrayList<Uri>()
                for (i in 0 until (clipData?.itemCount ?: 0)) {
                    clipData?.getItemAt(i)?.let {
                        uris.add(it.uri)
                    }
                }
                uris.reverse()
                uris.forEach {
                    CropImage.activity(it).start(
                        requireContext(),
                        this
                    )
                }
            } else if (data?.data != null) {
                data.data?.let {
                    CropImage.activity(it).start(
                        requireContext(),
                        this
                    )
                }
            }
        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode == Activity.RESULT_OK) {
                val uri = result.uri
                viewModel.setImages(listOf(uri.toString()))
            } else {
                result.error.message?.let {
                    snackbar(it)
                }
            }
        }
    }

    override fun deleteImage(position: Int) {
        viewModel.deleteImage(position)
    }
}