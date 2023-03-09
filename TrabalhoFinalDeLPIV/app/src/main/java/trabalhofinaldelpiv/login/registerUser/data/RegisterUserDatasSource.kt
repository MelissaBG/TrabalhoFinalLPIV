package trabalhofinaldelpiv.data
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
class RegisterUserDatasSource {
    private val service = RetrofitNetworkClient.createNetworkRegisterUser()
        .create(RegisterUserApi::class.java)

    suspend fun register( name: String, email: String, password: String): Result<RegisterResponse, ErrorModel>{
        return withContext(Dispatchers.IO) {
            try {
                val registerResponse = service.register(name= name, email = email, password = password)
                Result.Sucess(registerResponse)
            } catch(exeception: Exeception){
                Log.e("RegisterUserDataSource", exeception.messaage ?: "")
                Result.Error(ErrorModel.ErrorRegisterUser)
            }
        }

    }

}
