package com.fundatec.trabalhofinaldelpiv.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast.LENGTH_LONG
import androidx.activity.viewModels
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import br.com.fundatec.R
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.fundatec.trabalhofinaldelpiv.login.presentation.LoginViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

/*A classe LoginActivity estende a classe AppCpmpatActivity, que é uma das classe de atividades
* fornecidas pelo Android. Lida com a lógica de negócios da tela de login.*/
class LoginActivity : AppCompatActivity (){

/*Binding: uma instância da classe "ActivityLoginBinding' que é criada no método 'onCreate() da atividade. Essa classe é gerada automaticamente pelo Android apartir do XML que define a tela
* de aparencia da tela de login.*/
        private lateinit var binding: ActivityLoginBinding
/* viewModel: uma instãncia da classe LoginViewModel, que é criada usando o método viewModels() da classe AppCompatActivity. Essa classe contém a lógica de negócios e interage com o banco de dados.*/
        private val viewModel: LoginViewModel by viewModels()
/*O método onCreate() é chamado quando a activity é criada. Ele realiza váris ações:
* -Infla o layout XML da tela de login e define como o conteudo da activity.
* - Obtém uma referência às preferencias compertilhadas de aplicativo, usando o nome bd e o modo privado.
* - Converte o objeto character em uma string JSON e armazena nas preferências compartilhadas sob a chave character.
* -Define uma mensagem de erro no campo email usando a propriedade error de binding.etEmail.
* -Configura o botão de login para chamar a função viewModel.validateUserInput() quando for clicado.
* - Observa o estado da viewState do viewModel e cjhama a função shoSnack quando estado for ViewState.ShowHome.*/

        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)

            binding = ActivityLoginBinding.inflate(layoutInflater)

            setContentView(binding.root)

            configLoginButton()
            configObserver()


        }
    private fun configObservers() {
        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowHome -> showSnack()
                is ViewState.ShowHome -> showHome()
                is ViewState.ShowErrorEmptyFileds -> showSnackBarError(R.string.error_empty_fields)
                is ViewState.ShowLoading -> showLoading()
                is ViewState.ShowErrorApiLogin -> showSnackBarError(R.string.error_login)
            }
        }
    }
/*A função configLoginButton() é responsável por configurar o botão de login para chamar a função viewModel.validateUserInput()
* quando for clicado. A função showSnack() cria uma nova intenção para abrir a activity de perfil e a inicia.*/
        private fun configLoginButton() {

            binding.btLogin.setOnClickListener {

                viewModel.validateUserInput(

                    email = binding.etEmail.text.toString(),

                    password = binding.etPassword.text.toString(),)

            }

        }

    private fun showHome() {
        hideLoging()
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun showSnackBarError(@StringRes messageId: Int) {
        hideLoging()
        Snackbar.make(binding.container, messageId, Snackbar.LENGTH_LONG).show()
    }

    private fun showLoading() {
        binding.pbLoading.visibility = View.VISIBLE
    }

    private fun hideLoging() {
        binding.pbLoading.visibility = View.GONE
    }

}