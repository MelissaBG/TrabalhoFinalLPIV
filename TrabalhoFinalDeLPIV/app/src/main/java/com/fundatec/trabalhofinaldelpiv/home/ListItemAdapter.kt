package com.fundatec.trabalhofinaldelpiv.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
/*Define uma classe  chamada 'ListItemAdapter', que é uma implementação da classe 'RecyclerView.Adapter<ListItemViewHolder>'
* O bojetivo dessa classe é fornecer uma adaptador que pode ser usado para exibir uma lista de itens em um 'RecyclerView'*/

/*'class ListItemAdapter: RecyclerView.Adapte<ListItemViewHolder>()' define uma classe de mesmo nome, que estende a classe
* abstrata 'RecyclerView.Adapter' e especifica o que o tipo de 'ViewHolder' será usado é 'ListItemViewHolder'.*/
class ListItemAdapter : RecyclerView.Adapter<ListItemViewHolder>() {
    /*private val list = mutableListOf<String>() declara uma propriedade 'list', que é uma lista mutável de string vazia. Esta
    * lista será usada para armazenar os itens que serão exibidos no 'RecyclerView'.*/
    private val list = mutableListOf<String>()
    /*override fun onCreateViewHolder...é um método chamado quando o 'RecyclerView' precisa criar um novo 'ViewHolder' para
    * exibir um item. Neste método, estamos inflando a view a partir de um layout XML chamado 'ListItemBinding' usando um 'LayoutInflater'
    * e retornando um 'ListItemViewHolder' que envolve a view. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding)
    }
    /*Este método de substituição obrigatória da classe 'RecyclerView.Adapter' retorna o número de itens na lista que serão exibidos
    * no 'RecyclerView'. Aqui, estamos simplesmente retornando o tamanho da lista de itens. */
    override fun getItemCount(): Int {
        return list.size
    }
    /*ste método de substituição obrigatória da classe 'RecyclerView.Adapter' é chamado quando o 'RecyclerView'
    * está pronto para exibir um item na posição 'position'. Aqui, estamos chamando o método 'bind()'no 'ListItemViewHolder'
    * para configurar a exibição do item na posição 'position'. */
    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position])
    }
    /*Este método é definido pelo desenvolvedor e não é obrigado estar na classe RecyclerView. Aqui, estamos adicionando todos os itens à lista
    * de itens existentes.*/
    fun setItems(items: List<String>) {
        list.addAll(items)
    }
}
