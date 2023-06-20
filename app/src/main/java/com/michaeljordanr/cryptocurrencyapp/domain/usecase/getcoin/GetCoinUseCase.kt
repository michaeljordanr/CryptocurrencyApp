package com.michaeljordanr.cryptocurrencyapp.domain.usecase.getcoin

import com.michaeljordanr.cryptocurrencyapp.common.Resource
import com.michaeljordanr.cryptocurrencyapp.data.remote.dto.toCoin
import com.michaeljordanr.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.michaeljordanr.cryptocurrencyapp.domain.model.Coin
import com.michaeljordanr.cryptocurrencyapp.domain.model.CoinDetail
import com.michaeljordanr.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check you internet connection."))
        }
    }
}