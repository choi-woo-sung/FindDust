package com.ddd.pollpoll.network.api

import com.ddd.pollpoll.network.model.NetworkDust
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

internal interface DustAPI {

    @GET("/getCtprvnRltmMesureDnsty")
    suspend fun fetchDustList(
        @Query("serviceKey") serviceKey: String,
        @Query("returnType") returnType: String,
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("sidoName") sidoName: String
    ): NetworkDust
}
