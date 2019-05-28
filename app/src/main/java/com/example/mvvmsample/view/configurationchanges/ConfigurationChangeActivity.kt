package com.example.mvvmsample.view.configurationchanges

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsample.R
import kotlinx.android.synthetic.main.activity_configuration_change.*

class ConfigurationChangeActivity : AppCompatActivity() {
    private var counter: Int = 0
    private var viewModel: ConfigurationVM? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ConfigurationVM::class.java)
        setContentView(R.layout.activity_configuration_change)
        viewModel?.updateData?.observe(this, Observer {
            tvScore.text = " Score : $it"
        })

        /*  btnScorePlus.setOnClickListener {
              counter++
              tvScore.text = counter.toString()
          }*/
        btnScorePlus.setOnClickListener {
            // using view model
            viewModel?.getUpdatedData()?.observe(this, Observer {
                tvScore.text = " Score : $it"
            })

        }
    }
}
