package com.michaeljordanr.cryptocurrencyapp.domain.model

import com.michaeljordanr.cryptocurrencyapp.data.remote.dto.CoinDto

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
