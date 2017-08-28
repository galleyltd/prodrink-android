package io.prodrink.data.remote

import io.reactivex.Single
import retrofit2.http.GET

interface ProDrinkApiService {

    @GET("/search/drink")
    fun repoSearch(): Single<Boolean>
}