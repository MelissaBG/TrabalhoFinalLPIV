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

/*A classe RegisterUserActivity estende a classe AppCpmpatActivity, que é uma das classe de atividades
* fornecidas pelo Android. Lida com a lógica de negócios da tela de login.*/
class RegisterUserActivity : AppCompatActivity (){

        private lateinit var binding: ActivityRegisteruserBinding

        private val viewModel: RegisterUserViewModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)

            binding =ActivityRegisteruserBinding.inflate(layoutInflater)

            setContentView(binding.root)

            configLoginButton()
            configObserver()


        }
    private fun configObservers() {
        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowLogin -> showSnack()
                is ViewState.ShowErrorEmptyFileds -> showSnackBarError(R.string.error_empty_fields)
                is ViewState.ShowLoading -> showLoading()
                is ViewState.ShowErrorApiLogin -> showSnackBarError(R.string.error_login)
            }
        }
    }
/*A função configLoginButton() é responsável por configurar o botão de login para chamar a função viewModel.validateUserInput()
* quando for clicado. A função showSnack() cria uma nova intenção para abrir a activity de perfil e a inicia.*/
        private fun configLoginButton() {

            binding.etRegisterButton.setOnClickListener {

                viewModel.validateUserInput(
                    name = binding.etNameRegisterUser.text.toString(),
                    email = binding.etEmail.text.toString(),
                    password = binding.etPassword.text.toString(),)

            }

        }

    private fun showHome() {
        hideLoging()
        val intent = Intent(this@RegisterUserActivity, LoginActivity::class.java)
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