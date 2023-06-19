package com.michaeljordanr.cryptocurrencyapp.presentation.coindetail

import com.michaeljordanr.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
