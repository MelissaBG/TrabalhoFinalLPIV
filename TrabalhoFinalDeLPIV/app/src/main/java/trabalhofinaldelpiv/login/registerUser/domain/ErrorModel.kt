package com.fundatec.trabalhofinaldelpiv.login.presentation

sealed class ErrorModelRegisterUser{
    object ErrorRegisterUser : ErrorModel()
    object ErrorRegister : ErrorModel()
}