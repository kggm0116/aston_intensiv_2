package ru.kggm.task_2_1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.kggm.launcher.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    companion object {
        private val LOG_TAG = FirstActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setClickListeners() {
        binding.firstButton.setOnClickListener { launchSecondActivity() }
    }

    private fun launchSecondActivity() {
        Log.d(LOG_TAG, "Button clicked!");
    }
}