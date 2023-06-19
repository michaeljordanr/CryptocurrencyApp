package com.michaeljordanr.cryptocurrencyapp.domain.repository

import com.michaeljordanr.cryptocurrencyapp.data.remote.dto.CoinDetailTo
import com.michaeljordanr.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailTo
}