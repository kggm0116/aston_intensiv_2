package ru.kggm.part_1_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.StringRes
import androidx.core.os.LocaleListCompat
import ru.kggm.part_1_challenge.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @StringRes
    private var nameId = R.string.name_karim

    private fun getRandomNameId() = listOf(
        R.string.name_arthur,
        R.string.name_karim,
        R.string.name_oleg
    )
        .random()

    companion object {
        private const val NAME_ID_BUNDLE_KEY = "nameId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameId = savedInstanceState?.getInt(NAME_ID_BUNDLE_KEY) ?: getRandomNameId()
        setBirthdayText()
    }

    override fun onStart() {
        super.onStart()
        setBirthdayText()
    }

    override fun onLocalesChanged(locales: LocaleListCompat) {
        super.onLocalesChanged(locales)

        setBirthdayText()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NAME_ID_BUNDLE_KEY, nameId)
    }

    private fun setBirthdayText() {
        val localizedName = getString(nameId)
        binding.happyBirthdayText.text = getString(
            R.string.happy_birthday_text_template,
            localizedName
        )
    }
}