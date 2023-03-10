import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import trabalhofinaldelpiv.domain.UserUsecase

class ProfileViewModel : ViewModel() {

    private val usecase: UserUsecase by lazy {
        UserUsecase()
    }

    fun saveUser() {
        viewModelScope.launch {
            usecase.saveUser()
        }
    }
}