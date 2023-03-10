package trabalhofinaldelpiv.domain

import trabalhofinaldelpiv.profile.data.repository.UserRepository

class UserUsecase {

    private val repository: UserRepository by lazy {
        UserRepository()
    }

    suspend fun saveUser() {
        repository.saveUser()
    }

}