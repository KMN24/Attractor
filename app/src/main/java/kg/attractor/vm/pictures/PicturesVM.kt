package kg.attractor.vm.pictures

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kg.attractor.vm.BaseVM
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.ArrayList

class PicturesVM: BaseVM() {

    protected val _images = MutableLiveData<List<String>>(listOf())
    val images : LiveData<List<String>> = _images

    fun setImages(images: List<String>) {
        _images.apply {
            value = value?.plus(images)
        }
    }

    fun deleteImage(position: Int) {
        viewModelScope.launch {
            _images.postValue(_images.value?.filterIndexed { index, _ -> index != position }) }
    }
}