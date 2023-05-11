package ru.kggm.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.kggm.launcher.R
import ru.kggm.launcher.databinding.ActivityHelloToastBinding

class ActivityHelloToast : AppCompatActivity() {
    private lateinit var binding: ActivityHelloToastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloToastBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}