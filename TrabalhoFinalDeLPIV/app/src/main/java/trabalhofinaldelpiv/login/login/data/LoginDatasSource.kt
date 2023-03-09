package trabalhofinaldelpiv.data
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
class LoginDatasSource {
    private val service = RetrofitNetworkClient.createNetworkClient()
        .create(LoginApi::class.java)

    suspend fun login(email: String, password: String): Result<LoginResponse, ErrorModel>{
        return withContext(Dispatchers.IO) {
            try {
                val loginResponse = service.login(email = email, password = password)
                Result.Sucess(loginResponse)
            } catch(exeception: Exeception){
                Log.e("LoginDataSource", exeception.messaage ?: "")
                Result.Error(ErrorModel.ErrorLogin)
            }
        }

    }

}
