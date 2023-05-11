package ru.kggm.task_2_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doAfterTextChanged
import ru.kggm.launcher.databinding.ActivityFirstBinding
import ru.kggm.launcher.databinding.ActivityLauncherBinding
import ru.kggm.launcher.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    companion object {
        private val LOG_TAG = SecondActivity::class.java.simpleName
        private const val REPLY_TEXT_BUNDLE_ARG = "reply text"
        const val EXTRA_REPLY = "extra reply"
    }

    private lateinit var binding: ActivitySecondBinding
    private var messageText = ""
    private var replyText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        messageText = intent.getStringExtra(FirstActivity.EXTRA_MESSAGE)
            ?: run {
                Log.e(LOG_TAG, "Extra message was not received from First Activity")
                ""
            }
        binding.replyText.doAfterTextChanged { replyText = it.toString() }
        binding.replyButton.setOnClickListener { launchFirstActivity() }
        setMessage()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(REPLY_TEXT_BUNDLE_ARG, replyText)
    }

    private fun setMessage() {
        binding.textMessage.text = messageText
    }

    private fun launchFirstActivity() {
        Intent(this, FirstActivity::class.java)
            .putExtra(EXTRA_REPLY, replyText)
            .let {
                setResult(RESULT_OK, it)
                finish()
            }
    }
}