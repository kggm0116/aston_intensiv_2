package ru.kggm.helloworld

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
        super.onCreate(savedInstanceState)
        binding = ActivityHelloWorldBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(LOG_TAG, "Hello World")
    }
}