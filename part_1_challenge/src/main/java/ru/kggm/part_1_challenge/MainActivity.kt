package ru.kggm.part_1_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView
import ru.kggm.part_1_challenge.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var name: String

    companion object {
        private const val NAME_BUNDLE_KEY = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = savedInstanceState?.getString(NAME_BUNDLE_KEY) ?: getRandomName()
        setBirthdayText(name)
    }

    override fun onStart() {
        super.onStart()
        setBirthdayText(name)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(NAME_BUNDLE_KEY, name)
    }

    private fun setBirthdayText(name: String) {
        binding.happyBirthdayText.text = getString(R.string.happy_birthday_text_template, name)
    }

    private fun getRandomName() = listOf("Karim", "Arthur", "Oleg").random()
}