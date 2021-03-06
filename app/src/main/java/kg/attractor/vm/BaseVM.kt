package kg.attractor.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.attractor.domain.utils.Failure
import kotlinx.coroutines.launch

open class BaseVM : ViewModel() {

    protected val _failureLD = MutableLiveData<Failure>()
    val failureLD: LiveData<Failure> = _failureLD
    protected val _loadingLD = MutableLiveData<Boolean>()
    val loadingLD: LiveData<Boolean> = _loadingLD

    suspend fun withViewModelScope(fn: suspend () -> Unit) {
        viewModelScope.launch {
            _loadingLD.value = true
            fn()
            _loadingLD.value = false
        }
    }
}