package ru.kggm.task_2_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import ru.kggm.launcher.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    companion object {
        private val LOG_TAG = FirstActivity::class.java.simpleName
        private const val MESSAGE_TEXT_BUNDLE_ARG = "message text"
        const val EXTRA_MESSAGE = "extra message"
        const val TEXT_REQUEST = 1
    }

    private lateinit var binding: ActivityFirstBinding
    private var messageText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListeners()
        binding.sendText.doAfterTextChanged { messageText = it.toString() }
        setMessage()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(MESSAGE_TEXT_BUNDLE_ARG, messageText)
    }

    private fun setClickListeners() {
        binding.firstButton.setOnClickListener { launchSecondActivity() }
    }

    private fun setMessage() {
        binding.sendText.setText(messageText)
    }

    private fun launchSecondActivity() {
        Log.d(LOG_TAG, "Button clicked!")
        Intent(this, SecondActivity::class.java)
            .putExtra(EXTRA_MESSAGE, messageText)
            .let {
                // TODO("Replace deprecated api")
                startActivityForResult(it, TEXT_REQUEST)
            }
    }
}