package ru.kggm.task_1_1_challenge;

import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log
import androidx.annotation.StringRes
import androidx.core.os.LocaleListCompat
import ru.kggm.launcher.R
import ru.kggm.launcher.databinding.ActivityHappyBirthdayBinding


class HappyBirthdayActivity : AppCompatActivity() {
    companion object {
        private const val NAME_ID_BUNDLE_KEY = "nameId"
        private const val DEFAULT_NAME_ID = R.string.name_karim
    }

    private lateinit var binding: ActivityHappyBirthdayBinding

    @StringRes
    private var nameId = DEFAULT_NAME_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHappyBirthdayBinding.inflate(layoutInflater)
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

    private fun getRandomNameId() = listOf(
        R.string.name_arthur,
        R.string.name_karim,
        R.string.name_oleg,
        "BOGUS".hashCode()
    )
        .partition { resourceExists(it) }
        .let { (existing, notExisting) ->
            notExisting.forEach { id ->
                Log.e(
                    "Getting random name id",
                    "'$id' is not a valid id of a string resource"
                )
            }
            existing.randomOrNull() ?: DEFAULT_NAME_ID
        }

    private fun Context.resourceExists(id: Int): Boolean {
        try {
            resources.getResourceName(id)
        }
        catch (e: Resources.NotFoundException) {
            return false
        }
        return true
    }

    private fun setBirthdayText() {
        if (!resourceExists(nameId)) {
            Log.e("Setting birthday text", "'$nameId' is not a valid id of a name resource")
            return
        }
        val localizedName = getString(nameId)
        binding.happyBirthdayText.text = getString(
            R.string.happy_birthday_text_template,
            localizedName
        )
    }
}