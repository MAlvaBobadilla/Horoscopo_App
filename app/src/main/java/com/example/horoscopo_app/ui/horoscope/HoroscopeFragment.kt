package com.example.horoscopo_app.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.horoscopo_app.databinding.FragmentHoroscopeBinding
import com.example.horoscopo_app.domain.models.HoroscopeInfo
import com.example.horoscopo_app.domain.models.HoroscopeModel
import com.example.horoscopo_app.domain.models.HoroscopeModel.*
import com.example.horoscopo_app.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val viewModel by viewModels<HoroscopeViewModel>()

    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(
            layoutInflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        initUiState()
        initRecyclerView()
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.horoscope.collect {
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    private fun initRecyclerView() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {

            val data =
                when(it){
                    HoroscopeInfo.Acuario -> aquarius
                    HoroscopeInfo.Aries -> aries
                    HoroscopeInfo.Cancer -> cancer
                    HoroscopeInfo.Capricornio -> capricorn
                    HoroscopeInfo.Geminis -> gemini
                    HoroscopeInfo.Leo -> leo
                    HoroscopeInfo.Libra -> libra
                    HoroscopeInfo.Piscis -> pisces
                    HoroscopeInfo.Sagitario -> sagittarius
                    HoroscopeInfo.Scorpio -> scorpio
                    HoroscopeInfo.Tauro -> taurus
                    HoroscopeInfo.Virgo -> virgo
                }

            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToDetailActivity(datos = data)
            )
        })
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
    }

}