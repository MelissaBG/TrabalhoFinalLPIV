package trabalhofinaldelpiv.profile.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import trabalhofinaldelpiv.database.FHDatabase

class LocalDatasource {
    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }

    suspend fun save() {
        return withContext(Dispatchers.IO) {
            database.userDao().insertUser(
                UserEntity(
                    name = "Dionata",
                    email = "dionataferraz@gmail.com",
                    password = "123456"
                )
            )

            Log.e("teste realizado com sucesso", "${ database.userDao().getUser()}")
        }
    }
}

