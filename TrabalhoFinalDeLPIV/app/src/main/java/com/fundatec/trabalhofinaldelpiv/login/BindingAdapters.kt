package com.fundatec.trabalhofinaldelpiv.login

import android.view.View
/*Aqui usamos o BindigAdapter do Android Data Binding Library para criar um método personalizado que pode se vinculado a uma
* propriedade de um elemento de interface do usuário.
* Nesse caso, p método personalizado 'visibility' é criado para vincular a propriedade "app: visibility de uma View.
* Quando essa propriedade é definida em layout XML, ela chama o método 'visibility' persinalizado e passa um valor booleano
* para determinar se a visibilidade DA vIEW DEVE SER DEFINIDA COMO 'View.VISIBLE' (visivel) ou 'View.GONE'(Invisivel)*/
@BindingAdapter("app:visibility")
fun View.visibility(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}