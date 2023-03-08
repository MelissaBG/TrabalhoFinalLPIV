package com.fundatec.trabalhofinaldelpiv.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fundatec.trabalhofinaldelpiv.databinding.FragmentCharactersBinding

/*Implementa uma classe 'CharactersFragment' que estende a classe 'Fragment'. Ela é usada para exibir uma lista de
* caracters em um view.*/
/*A propriedade 'binding' é do tipo 'FragmentCharactersBinding' é é declarada como 'lateinit' para que seja
    * inicializada mais tarde. Ela é usada para acessar as views no layout XML do fragmento.
    * A propriedade 'list' é uma lista de 'String' com 11 elementos, que são os números de 1 a 11.
    * O método 'onCreateView' é chamado quando a view do fragmento é criada. Ele infla o layout XML do fragmento usando o objeto inflater'
    * e inicializa a propriedade 'binding' com o resultado da inflação'.
    * O método 'onViewCreated' é chamado após a view do fragmento ser criada. Ele cria um novo objeto 'ListItemAdapter',
    * que é um adaptador para o que exibe cada elemento da lista 'list' em uma view. Ele define o adaptador para a view
    * da lsita 'binding.list' e chama o método 'setItem' do adaptador para definir os itens a serem exibidos na lista.
    * O método 'newInstance' é uma função de fábrica que cria uma nova instância da classe 'CharactersFragment'*/
class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding

    private val list = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListItemAdapter()
        binding.list.adapter = adapter

        adapter.setItems(list)
    }


    companion object {
        fun newInstance() = CharactersFragment()
    }
}
/*RESUMO: A classe CharacterFragment é usada para exibir uma lista de caracteres em uma view, usando um adaptador
* personalizado para exibir cada elemento de lista em uma view.*/