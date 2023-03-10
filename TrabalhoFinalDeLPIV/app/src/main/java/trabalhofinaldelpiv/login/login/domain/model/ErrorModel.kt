package com.fundatec.trabalhofinaldelpiv.login.presentation

sealed class ErrorModel{
    object ErrorLogin : ErrorModel()
    object ErrorRegister : ErrorModel()
}