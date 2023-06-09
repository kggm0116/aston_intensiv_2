package ru.kggm.task_1_2_A

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.kggm.launcher.R
import ru.kggm.launcher.databinding.ActivityHelloToastUpgradeBinding

class HelloToastUpgradeActivity : AppCompatActivity() {
    companion object {
        private const val COUNT_BUNDLE_KEY = "count"
    }

    private lateinit var binding: ActivityHelloToastUpgradeBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloToastUpgradeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState?.getInt(COUNT_BUNDLE_KEY)?.let {
            count = it
            updateCount()
        }

        setClickHandlers()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_BUNDLE_KEY, count)
    }

    private fun setClickHandlers() {
        binding.toastButton.setOnClickListener { showToast() }
        binding.countButton.setOnClickListener { countUp() }
    }

    private fun showToast() {
        Toast
            .makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
            .show()
    }

    private fun countUp() {
        count++
        updateCount()
    }

    private fun updateCount() {
        binding.showCount.text = count.toString()
    }
}