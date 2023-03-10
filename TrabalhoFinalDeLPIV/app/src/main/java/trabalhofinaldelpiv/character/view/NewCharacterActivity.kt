package com.fundatec.trabalhofinaldelpiv


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fundatec.trabalhofinaldelpiv.databinding.ActivityNewCharacterBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class NewCharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewCharacterBinding

    private val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getSharedPreferences("bd", MODE_PRIVATE)

        val characterFromPreferences = moshi
            .adapter(Character::class.java)
            .fromJson(preferences.getString("character", ""))

        binding.tvName.text =
            "Name ${characterFromPreferences?.name} \nIdade ${characterFromPreferences?.age}"
    }

}

data class Character(
    val name: String,
    val age: Int
)