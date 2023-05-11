package ru.kggm.launcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.kggm.task_1_1.HelloWorldActivity
import ru.kggm.launcher.databinding.ActivityLauncherBinding
import ru.kggm.task_1_1_challenge.HappyBirthdayActivity
import ru.kggm.task_1_2_A.HelloToastActivity
import ru.kggm.task_1_2_A.HelloToastUpgradeActivity
import ru.kggm.task_1_2_B_homework.HelloToastConstraintActivity
import ru.kggm.task_1_2_challenge.HelloToastChallengeActivity
import ru.kggm.task_1_3.ScrollingActivity
import ru.kggm.task_2_1.FirstActivity

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
        binding.task12AHomeworkButton.setOnClickListener {
            startActivity(Intent(this, HelloToastActivity::class.java))
        }
        binding.task12AChallengeButton.setOnClickListener {
            startActivity(Intent(this, HelloToastChallengeActivity::class.java))
        }
        binding.task12BHomeworkButton.setOnClickListener {
            startActivity(Intent(this, HelloToastConstraintActivity::class.java))
        }
        binding.task13HomeworkButton.setOnClickListener {
            startActivity(Intent(this, ScrollingActivity::class.java))
        }

        binding.task21HomeworkButton.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }
    }


}