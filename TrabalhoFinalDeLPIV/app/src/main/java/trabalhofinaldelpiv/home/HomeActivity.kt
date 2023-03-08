package com.fundatec.trabalhofinaldelpiv.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.fundatec.trabalhofinaldelpiv.databinding.ActivityHomeBinding

/*Tela inicial de um aplicativo que tem duas abas, cada uma com um fragmento(CharactersFragment) exibindo
* diferentes informações. O código usa o padrão de arquitetura Android com biblioteca de suporte para fragmentos.
*/
class HomeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

/*O método onCreate() é chamdo quando a Activity é criada e configura a View,
chama os métodos de configuração da ActionBar e das Tabs, e define o conteúdo da Activity usando o 'setContentView()'*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar()
        configTab()
    }
    /*O código usa o ViewPagerAdapter para exibir as duas abas na tela, cada uma com um Fragmento que é preenchido com dados
    * difrentes. A configuração das abas é feita no método 'configTab()' que define o adaptador para o ViewPager e o tabLayout
    * usando o método 'setupWithViewPager()'*/
    private fun configTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        binding.vpHome.adapter = adapter
        binding.tlHome.setupWithViewPager(binding.vpHome)
    }
/*O método 'configActionBar()' configura a barra de navegação superior usando o objeto 'tbNavigation' do layuot,
* que deve ser definido na Activity e é acessado por meio do objeto 'binding'.*/
    private fun configActionBar() {
        setSupportActionBar(binding.tbNavigation)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
/*O ViewPagerAdapter estende FragmentStatePagerAdaoter e fornece os métodos 'getCount', 'getPageTitle()' e 'getItem()'
* O método 'getCount()' retorna o número de abas, neste caso 2. O método 'getPageTitle()' retorna um título para cada aba, neste caso
* Tab1 e Tab2.
* O método 'getItem()' retorna o Fragmento para as duas abas, 'CharacterFragment.newInstance()'*/
class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Tab ${position.inc()}"
    }

    override fun getItem(position: Int): Fragment {
        return CharactersFragment.newInstance()
    }

}
/*RESUMO: Configura uma tela com duas abas e duas instâncias do mesmo Fragmento, exibindo diferentes informações
* em cada aba, usando um ViewPager e um TabLayout.*/