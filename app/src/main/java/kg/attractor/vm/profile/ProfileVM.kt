package kg.attractor.vm.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kg.attractor.R
import kg.attractor.domain.entities.EducationType
import kg.attractor.domain.entities.User
import kg.attractor.domain.use_cases.GetUserUC
import kg.attractor.domain.utils.BaseUseCase
import kg.attractor.domain.utils.onFailure
import kg.attractor.domain.utils.onSuccess
import kg.attractor.vm.BaseVM

class ProfileVM(
    private val getUserUC: GetUserUC
): BaseVM() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun getUser(){
        getUserUC(BaseUseCase.None, viewModelScope){ result ->
            result
                .onSuccess { _user.value = it }
                .onFailure { _failureLD.value = it }
        }
    }

    fun getEducationByType(educationType: EducationType) =
        when(educationType) {
            EducationType.HIGH_SCHOOL -> R.string.high_school
            EducationType.BACHELOR -> R.string.bachelor
            EducationType.MASTER -> R.string.master
            EducationType.DOCTORAL -> R.string.doctoral
            EducationType.UNDEFINED -> R.string.undefined

        }
}