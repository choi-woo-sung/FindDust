package com.ddd.pollpoll.network.api

import com.ddd.pollpoll.network.model.Dust
import retrofit2.http.Field
import retrofit2.http.GET

interface DustAPI {

    @GET("/getCtprvnRltmMesureDnsty")
    suspend fun fetchDustList(
        @Field("serviceKey") serviceKey: String,
        @Field("returnType") returnType: String,
        @Field("numOfRows") numOfRows: Int,
        @Field("pageNo") pageNo: Int,
        @Field("sidoName") sidoName: String
    ): Dust
}
