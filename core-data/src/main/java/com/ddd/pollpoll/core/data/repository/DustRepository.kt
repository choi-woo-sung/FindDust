package com.ddd.pollpoll.core.data.repository

interface DustRepository {

    suspend fun syncDustList(numOfRows: Int, pageNo: Int, sidoName: String): Boolean
}
