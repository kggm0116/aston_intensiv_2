package ru.kggm.task_2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.kggm.launcher.databinding.ActivityFirstBinding
import ru.kggm.launcher.databinding.ActivityLauncherBinding
import ru.kggm.launcher.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}