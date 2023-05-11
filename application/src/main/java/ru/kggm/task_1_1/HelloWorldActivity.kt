package ru.kggm.task_1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.kggm.launcher.databinding.ActivityHelloWorldBinding

class HelloWorldActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHelloWorldBinding
    companion object {
        private val LOG_TAG = HelloWorldActivity::class.simpleName!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(LOG_TAG, "Entered 'onCreate' method")
        super.onCreate(savedInstanceState)
        Log.v(LOG_TAG, "Called 'super.onCreate'")

        binding = ActivityHelloWorldBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.w(LOG_TAG, "ContentView is set; Activity is initialized.")

        Log.d(LOG_TAG, "Hello World")
    }
}