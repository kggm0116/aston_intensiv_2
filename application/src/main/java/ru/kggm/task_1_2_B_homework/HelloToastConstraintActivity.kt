package ru.kggm.task_1_2_B_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.kggm.launcher.R
import ru.kggm.launcher.databinding.ActivityHelloToastConstraintBinding

class HelloToastConstraintActivity : AppCompatActivity() {
    companion object {
        private const val COUNT_BUNDLE_KEY = "count"
    }

    private lateinit var binding: ActivityHelloToastConstraintBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloToastConstraintBinding.inflate(layoutInflater)
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
        binding.zeroButton.setOnClickListener { resetCount() }
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

    private fun resetCount() {
        count = 0
        updateCount()
    }

    private fun updateCount() {
        binding.showCount.text = count.toString()

        val zeroButtonBackground = if (count == 0)
            R.color.gray
        else
            R.color.color_primary
        val countButtonBackground = if (count % 2 == 0)
            R.color.color_count_even
        else
            R.color.color_count_odd

        binding.zeroButton.setBackgroundResource(zeroButtonBackground)
        binding.countButton.setBackgroundResource(countButtonBackground)
    }
}