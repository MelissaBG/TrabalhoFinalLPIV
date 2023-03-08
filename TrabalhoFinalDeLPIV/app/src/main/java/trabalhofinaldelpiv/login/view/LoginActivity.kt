package com.fundatec.trabalhofinaldelpiv.login.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fundatec.trabalhofinaldelpiv.login.presentation.LoginViewModel

/*A classe LoginActivity estende a classe AppCpmpatActivity, que é uma das classe de atividades
* fornecidas pelo Android. Lida com a lógica de negócios da tela de login.*/
class LoginActivity : AppCompatActivity (){
    /*É uma instância da bibliotec Moshi, usada para serializar/deserializar objetos JSON. Ela é criada com um padrão "lazy"
    * (ous seja, é criada apenas quando for usada pela primeira vez) e configurada com um KotlinJsonAdapterFactory.*/
        private val moshi by lazy {

            Moshi.Builder()

                .add(KotlinJsonAdapterFactory())

                .build()

        }
/*Character: Uma instância da classe "Character"( não definida no código) contendo o nome e a idade do personagem. Essa váriavel tembém é
* criada com um padrão 'lazy'*/
        private val character by lazy {

            Character("Batman", 40)

        }
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

            val preferences = getSharedPreferences("bd", MODE_PRIVATE)

            val characterString = moshi.adapter(Character::class.java).toJson(character)

            preferences.edit().putString("character", characterString).commit()

            binding.etEmail.error = "Campo obrigatório"

            configLoginButton()

            viewModel.viewState.observe(this) { state -> when (state) {

                is ViewState.ShowHome -> showSnack()

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

        private fun showSnack() {

            val intent = Intent(this@LoginActivity,

                ProfileActivity::class.java)

            startActivity(intent)

        }

    }
}