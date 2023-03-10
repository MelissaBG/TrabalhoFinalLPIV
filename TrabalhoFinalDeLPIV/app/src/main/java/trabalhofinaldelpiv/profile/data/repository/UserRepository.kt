package trabalhofinaldelpiv.profile.data.repository

import trabalhofinaldelpiv.database.LocalDatasource

class UserRepository {

    private val localDatasource: LocalDatasource by lazy {
        LocalDatasource()
    }

    suspend fun saveUser() {
        localDatasource.save()
        localDatasource.save()
    }

}