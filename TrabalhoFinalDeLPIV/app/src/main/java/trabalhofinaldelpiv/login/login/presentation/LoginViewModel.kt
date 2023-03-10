package com.fundatec.trabalhofinaldelpiv.login.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import trabalhofinaldelpiv.login.login.data.LoginDataSource
import trabalhofinaldelpiv.login.login.presentation.ViewState

//'LoginViewModel' que é uma subclasse 'ViewModel'. Essa classe gernecia a lógica de negócio e a comunicação entre a camada de vizualização
// e a camada de dados.

class LoginViewModel : ViewModel() {

    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    fun validateUserInput(email: String?, password: String?) {
        viewModelScope.launch {
            state.value = ViewState.ShowLoading
            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                val user = LoginDataSource().login(email, password)
                if (user.get() != null) {
                    state.value = ViewState.ShowHome
                } else {
                    state.value = ViewState.ShowErrorApiLogin
                }
            } else {
                state.value = ViewState.ShowErrorEmptyFileds
            }
        }
    }
}

