package ru.kggm.task_1_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.kggm.launcher.R
import ru.kggm.launcher.databinding.ActivityLauncherBinding
import ru.kggm.launcher.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScrollingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}