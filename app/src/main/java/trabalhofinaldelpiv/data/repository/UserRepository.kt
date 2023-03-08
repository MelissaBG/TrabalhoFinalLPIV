package trabalhofinaldelpiv.data.repository

import trabalhofinaldelpiv.data.LocalDatasource

class UserRepository {

    private val localDatasource: LocalDatasource by lazy {
        LocalDatasource()
    }

    suspend fun saveUser() {
        localDatasource.save()
        localDatasource.save()
    }

}