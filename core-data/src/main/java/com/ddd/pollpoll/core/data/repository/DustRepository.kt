package com.ddd.pollpoll.core.data.repository

import com.ddd.pollpoll.network.model.Dust
import kotlinx.coroutines.flow.Flow

interface DustRepository {
//    val logins: Flow<List<String>>

    suspend fun getDustList(numOfRows: Int, pageNo: Int, sidoName: String): Flow<Dust>
}
