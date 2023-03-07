package com.fundatec.trabalhofinaldelpiv.home

import androidx.recyclerview.widget.RecyclerView
/*Essa classe é usada como um item de visualização dentro de um RecyclerView.
* O construtor da classe ListItem ViewHolder recebe um objeto 'binding' da classe
* ListItemBinding que é usado para associar os elementos visuais do item de visualização
* (como TextViews e ImageViews) com os daos que serão exibidos.
* O métoda bind é usado para atualizar a exibição do item com os dados fornecidos. Neste caso,
* o método recebe uma string 'name' e define o texto de um TextView chamado 'tvName' no layout associado ao item
* de visualização usando o valor de 'name'.*/
class ListItemViewHolder {
    class ListItemViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String) {
            binding.tvName.text = name
        }
    }
}
/*RESUMO: Essa classe define o layout e comportamento de um item de visualização
em Recyclerview, vinculando os dados com os elementos visuais do item. */