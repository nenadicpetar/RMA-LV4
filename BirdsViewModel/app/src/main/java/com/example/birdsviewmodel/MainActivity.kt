package com.example.birdsviewmodel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.birdsviewmodel.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setVariable(BR.counterViewModel, viewModel)

        val countLiveData: LiveData<Int> = viewModel.initialCount()
        countLiveData.observe(this, Observer {
            binding.birdCounter.text = it.toString()
        })

        val colorLiveData: LiveData<Int> = viewModel.getInitialColor()
        colorLiveData.observe(this, Observer {
            binding.mainLayout.setBackgroundColor(it)
        })

        red_button.setOnClickListener {
            updateData(viewModel.getCount() + 1, Color.RED)
        }

        green_button.setOnClickListener {
            updateData(viewModel.getCount() + 1, Color.GREEN)
        }

        blue_button.setOnClickListener {
            updateData(viewModel.getCount() + 1, Color.BLUE)
        }

        yellow_button.setOnClickListener {
            updateData(viewModel.getCount() + 1, Color.YELLOW)
        }

        reset_button.setOnClickListener {
            updateData(0, Color.WHITE)
        }
    }

    private fun updateData(newCount: Int, background: Int) {
        viewModel.setCount(newCount)
        viewModel.setColor(background)
    }
}