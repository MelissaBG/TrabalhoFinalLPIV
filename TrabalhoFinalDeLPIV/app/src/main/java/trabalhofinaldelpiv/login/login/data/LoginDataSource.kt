package trabalhofinaldelpiv.login.login.data
import android.util.Log
import com.fundatec.trabalhofinaldelpiv.login.presentation.ErrorModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import trabalhofinaldelpiv.webservice.Result
import trabalhofinaldelpiv.webservice.RetrofitNetworkClient

class LoginDataSource {
    private val service = RetrofitNetworkClient.createNetworkClient()
        .create(LoginApi::class.java)

    suspend fun login(email: String, password: String): Result<LoginResponse, ErrorModel>{
        return withContext(Dispatchers.IO) {
            try {
                val loginResponse = service.login(email = email, password = password)
                Result.Success(loginResponse)
            } catch(exeception: Exception){
                Log.e("LoginDataSource", exeception.message ?: "")
                Result.Error(ErrorModel.ErrorLogin)
            }
        }

    }

}
