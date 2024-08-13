package com.example.horoscopo_app.ui.horoscope.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopo_app.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()

    private val args: DetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
        detailViewModel.getPredictionUseCase(args.datos)
    }

    private fun initUi() {
        initListeners()
        initUiState()
    }

    private fun initListeners() {
        binding.ivButtomBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                detailViewModel.state.collect {
                    when (it) {
                        DetailState.Loading -> loadingState()
                        is DetailState.Error -> errorState()
                        is DetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }

    private fun errorState() {
        binding.pb.isVisible = false
        Log.i("Aviso", "Ha ocurrido un error")
    }

    private fun successState(data: DetailState.Success) {
        binding.pb.isVisible = false
        Picasso.get()
            .load(data.img)
            .into(binding.ivDetail)
        binding.tvTitle.text = data.title
        binding.tvDetail.text = data.prediction
    }
}