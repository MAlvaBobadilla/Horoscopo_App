package com.example.horoscopo_app.domain.usecase

import com.example.horoscopo_app.domain.Repository
import javax.inject.Inject

class GetPrediction @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(sign: String) = repository.getPrediction(sign = sign)

}