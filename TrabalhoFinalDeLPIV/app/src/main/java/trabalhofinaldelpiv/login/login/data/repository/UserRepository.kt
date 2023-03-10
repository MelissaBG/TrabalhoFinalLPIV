package trabalhofinaldelpiv.login.login.data.repository


import trabalhofinaldelpiv.profile.data.LocalDatasource

class UserRepository {

    private val localDatasource: LocalDatasource by lazy {
        LocalDatasource()
    }

    suspend fun saveUser() {
        localDatasource.save()
        localDatasource.save()
    }

}