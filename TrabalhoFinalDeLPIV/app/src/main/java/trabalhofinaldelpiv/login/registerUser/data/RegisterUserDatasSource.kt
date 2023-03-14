package trabalhofinaldelpiv.login.registerUser.data
import android.util.Log
import com.fundatec.trabalhofinaldelpiv.login.presentation.ErrorModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import trabalhofinaldelpiv.database.RegisterResponse
import trabalhofinaldelpiv.database.RegisterUserApi
import trabalhofinaldelpiv.webservice.Result
import trabalhofinaldelpiv.webservice.RetrofitNetworkClient

class RegisterUserDatasSource {
    private val service = RetrofitNetworkClient.createNetworkClient()
        .create(RegisterUserApi::class.java)

   suspend fun register(email: String, password: password): Result<RegisterResponse, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val registerResponse = service.register(email = email, password = password)
                Result.Success(registerResponse)
            } catch(exeception: Exception){
                Log.e("RegisterUserDataSource", exeception.message ?: "")
                Result.Error(ErrorModel.ErrorRegister)
            }
        }
    }

}
