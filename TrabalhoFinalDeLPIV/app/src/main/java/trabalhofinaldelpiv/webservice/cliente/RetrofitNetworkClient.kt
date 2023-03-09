package trabalhofinaldelpiv.data

import androidx.databinding.ktx.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
/*Aqui implementamos uma classe 'RetrofitNetworkClient' que encapsula a configuração do cliente HTTP Retrofit.
* Ele define métodos privados para configurar o 'OkHttpClient' e o 'MoshiConverterFactory', e um método público
* para criar e retornar um objeto Retrofit. */
private const val TIME_OUT = 60L

object RetrofitNetworkClient {
        /* O método 'createNetworkClient' cria um objeto Retrofit com as configurações fornecidas pelos métodos
        * 'httpClint'  e 'moshi'. O parâmetro 'baseUrl' é opcional e, se não for fornecido, ele usa o valor padrão.
        * definido na classe 'BuildConfig.HTTP_SERVER'   */
        fun createNetworkClient(baseUrl: String = BuildConfig.HTTP_SERVER) =
            retrofitClient(
                baseUrl,
                httpClint(),
                moshi()
            )
        /*O método 'moshi' cria um 'MoshiConverterFactory' que utiliza o construtor de um 'Moshi.Builder'
        * Neste caso estamos adicionando um adaptador para suportar a serialização/deserialização de objetos Kotlin. */
        private fun moshi() = MoshiConverterFactory.create(
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        )
        /*O método cria um objeto 'OkHttpClient' com um interceptor de login que adicionado por meio do método
        * 'logginInterceptor()'. O timeout é padrão de conexão, leitura e escrita é definido como 60 segundos.*/
        private fun httpClint(): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(logginInterceptor())
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build()
        /*Cria e configura um interceptor do tipo ' HttpLoggingInterceptor', que é usado para logar as requisições e respostas.
        * O modo DEBUG, é definido no nivel 'BODY' para que as informações sejam logadas. Caso contrário não loga.*/
        private fun logginInterceptor() =
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
        /*O método 'retrofitClient' cria e retorna um objeto Retrofit com a baseURL fornecida, o 'OkHttpClient'
        * criado pelo método ' htttpClient' e o ' moshiConverterFactory' pelo método 'Moshi'. Objeto Retrofit é criado por
        * meio de um objeto 'Retrofit.Builder()'*/
        private fun retrofitClient(
            baseUrl: String,
            htttpClient: OkHttpClient,
            moshiConverterFactory: MoshiConverterFactory
        ) = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(htttpClient)
            .addConverterFactory(moshiConverterFactory)
            .build()

    }

}
