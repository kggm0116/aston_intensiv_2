package ru.kggm.launcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.kggm.helloworld.HelloWorldActivity
import ru.kggm.launcher.databinding.ActivityLauncherBinding
import ru.kggm.happybirthday.HappyBirthdayActivity
import ru.kggm.hellotoast.HelloToastActivity

class LauncherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLauncherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.task11HomeworkButton.setOnClickListener {
            startActivity(Intent(this, HelloWorldActivity::class.java))
        }
        binding.task11ChallengeButton.setOnClickListener {
            startActivity(Intent(this, HappyBirthdayActivity::class.java))
        }
        binding.task12HomeworkButton.setOnClickListener {
            startActivity(Intent(this, HelloToastActivity::class.java))
        }
    }


}