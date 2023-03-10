package trabalhofinaldelpiv.login.registerUser.presentation

sealed class ViewState {
    object ShowRegisterUser : ViewState()
    object ShowLoading : ViewState()
    object ShowErrorEmptyFields : ViewState()
    object ShowErrorApiRegisterUser : ViewState()
}