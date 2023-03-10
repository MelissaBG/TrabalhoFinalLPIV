package com.fundatec.trabalhofinaldelpiv.login.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import trabalhofinaldelpiv.login.login.presentation.ViewState
import trabalhofinaldelpiv.login.registerUser.data.RegisterUserDatasSource

//'LoginViewModel' que é uma subclasse 'ViewModel'. Essa classe gernecia a lógica de negócio e a comunicação entre a camada de vizualização
// e a camada de dados.

class RegisterUserViewModel : ViewModel() {

    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state
    /*Ele contém o método 'validateUserInput que valida as entradas do usuário para o email e senha e tenta fazer login com esse dados.
    Se o login for bem-sucedido, ele atualiza o estado 'ViewState' para 'ShowHome'.*/
    /* O método 'validateUserInput' usa a função 'launch' do escopo 'viewModelScope' para executar as operações assincronas em uma rotina
    * de modo que a chamada do método verifica se o email e a senha não estão vazios ou nulos,  em seguida, usa um objeto 'LoginDataSourse'
    * para tentar fazer login com essas credenciais. Seo o lgin for bem-sucedido, o estado 'ViewState' é atualizado para 'ShowHome'*/
    fun validateUserInput(name: String?, email: String?, password: String?) {
        viewModelScope.launch {
            if (!name.isNullOrEmpty() && !email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                val registerUser = RegisterUserDatasSource().register(name, email, password)
                if (registerUser.get() != null) {
                    state.value = ViewState.ShowRegisterUser
                }
            }
        }
    }
}
