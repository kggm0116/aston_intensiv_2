package ru.kggm.task_2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.kggm.launcher.databinding.ActivityFirstBinding
import ru.kggm.launcher.databinding.ActivityLauncherBinding
import ru.kggm.launcher.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    companion object {
        private val LOG_TAG = SecondActivity::class.java.simpleName
    }

    private lateinit var binding: ActivitySecondBinding
    private var messageText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        messageText = intent.getStringExtra(FirstActivity.EXTRA_MESSAGE)
            ?: run {
                Log.e(LOG_TAG, "Extra message was not received from First Activity")
                ""
            }
        setMessage()
    }

    private fun setMessage() {
        binding.textMessage.text = messageText
    }
}