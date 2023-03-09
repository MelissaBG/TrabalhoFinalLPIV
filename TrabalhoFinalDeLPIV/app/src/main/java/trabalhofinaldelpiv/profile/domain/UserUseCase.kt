package trabalhofinaldelpiv.domain

class UserUsecase {

    private val repository: UserRepository by lazy {
        UserRepository()
    }

    suspend fun saveUser() {
        repository.saveUser()
    }

}