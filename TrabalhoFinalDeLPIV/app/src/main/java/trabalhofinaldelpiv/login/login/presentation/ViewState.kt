package trabalhofinaldelpiv.login.login.presentation

sealed class ViewState {

        object ShowHome : ViewState()
        object ShowLoading : ViewState()
        object ShowErrorEmptyFileds : ViewState()
        object ShowErrorApiLogin : ViewState()

}