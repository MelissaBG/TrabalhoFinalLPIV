package trabalhofinaldelpiv.data

import androidx.databinding.ktx.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 60L

object RetrofitNetworkCharacter {
    // 2. Configurando a biblioteca de rede Retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")
        .build()

    // 3. Criando uma solicitação POST para salvar o personagem
    val api = retrofit.create(PersonagemApi::class.java)
    val personagem = Personagem("João", 28, 1.75f, listOf("pulo alto", "corrida rápida"))
    api.salvarPersonagem(personagem).enqueue(object: Callback<Void> {
        override fun onResponse(call: Call<Void>, response: Response<Void>) {
            // 4. Tratando as respostas da API
            if (response.isSuccessful) {
                // Personagem salvo com sucesso
                exibirMensagem("Personagem salvo com sucesso!")
            } else {
                // Ocorreu algum erro ao salvar o personagem
                exibirMensagem("Erro ao salvar o personagem.")
            }
        }

        override fun onFailure(call: Call<Void>, t: Throwable) {
            // Ocorreu algum erro na comunicação com a API
            exibirMensagem("Erro ao se comunicar com a API.")
        }
    })

    // 5. Exibindo feedback para o usuário
    fun exibirMensagem(mensagem: String) {
        // Implemente aqui a lógica para exibir a mensagem para o usuário
    }

}
