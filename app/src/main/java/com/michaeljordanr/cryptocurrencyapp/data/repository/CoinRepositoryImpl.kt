package com.michaeljordanr.cryptocurrencyapp.data.repository

import com.michaeljordanr.cryptocurrencyapp.data.remote.CoinPatrikaApi
import com.michaeljordanr.cryptocurrencyapp.data.remote.dto.CoinDetailTo
import com.michaeljordanr.cryptocurrencyapp.data.remote.dto.CoinDto
import com.michaeljordanr.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPatrikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailTo {
        return api.getCoinById(coinId)
    }
}