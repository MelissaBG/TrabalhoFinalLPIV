package com.fundatec.trabalhofinaldelpiv.login.presentation

import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import trabalhofinaldelpiv.login.data.LocalDataSource
import trabalhofinaldelpiv.login.data.LocalDatasSource
import trabalhofinaldelpiv.data.LoginDatasSource

//'LoginViewModel' que é uma subclasse 'ViewModel'. Essa classe gernecia a lógica de negócio e a comunicação entre a camada de vizualização
// e a camada de dados.

class LoginViewModel : ViewModel() {
    /*A classe LocalDataSourse é uma dependência que é criada usando 'lazy initialiaztion' e é usada para acessar dados locais.*/
    private val localDatasource: LocalDataSource by lazy {
        LocalDataSource()
    }

    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state
    /*Ele contém o método 'validateUserInput que valida as entradas do usuário para o email e senha e tenta fazer login com esse dados.
    Se o login for bem-sucedido, ele atualiza o estado 'ViewState' para 'ShowHome'.*/
    /* O método 'validateUserInput' usa a função 'launch' do escopo 'viewModelScope' para executar as operações assincronas em uma rotina
    * de modo que a chamada do método verifica se o email e a senha não estão vazios ou nulos,  em seguida, usa um objeto 'LoginDataSourse'
    * para tentar fazer login com essas credenciais. Seo o lgin for bem-sucedido, o estado 'ViewState' é atualizado para 'ShowHome'*/
    fun validateUserInput(email: String?, password: String?) {
        viewModelScope.launch {
            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                val user = LoginDatasSource().login(email, password)
                if (user != null) {
                    state.value = ViewState.ShowHome
                }
            }
        }
    }
}
/* A classe ViewSate é uma classe que é usada para definir o estado atual da interface do usuário. Atualmente, a única opção de estado é 'ShowHome'*/
sealed class ViewState {
    object ShowHome : ViewState()
}