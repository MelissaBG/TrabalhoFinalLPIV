package com.fundatec.trabalhofinaldelpiv.login.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import trabalhofinaldelpiv.login.registerUser.presentation.ViewState
import trabalhofinaldelpiv.login.registerUser.data.RegisterUserDatasSource

//'LoginViewModel' que é uma subclasse 'ViewModel'. Essa classe gernecia a lógica de negócio e a comunicação entre a camada de vizualização
// e a camada de dados.

class RegisterUserViewModel : ViewModel() {

    private val stateRegister = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = stateRegister

    fun validateUserInput(email: String?, password: String?) {
        viewModelScope.launch {
            stateRegister.value = ViewState.ShowLoading
            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                val registerUser = RegisterUserDatasSource().register(email, password)
                if (registerUser.get() != null) {
                    stateRegister.value = ViewState.ShowRegisterUser
                } else {
                    stateRegister.value = ViewState.ShowErrorApiRegisterUser
                }
            } else {
                stateRegister.value = ViewState.ShowErrorEmptyFields
            }
        }
    }
}
