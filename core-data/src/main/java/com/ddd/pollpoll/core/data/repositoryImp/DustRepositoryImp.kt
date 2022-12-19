package com.ddd.pollpoll.core.data.repositoryImp

import com.ddd.pollpoll.core.data.model.asEntity
import com.ddd.pollpoll.core.data.repository.DustRepository
import com.ddd.pollpoll.core.database.DustDao
import com.ddd.pollpoll.network.model.Item
import com.ddd.pollpoll.network.remotesource.DustRemoteSource
import javax.inject.Inject

class DustRepositoryImp @Inject constructor(
//    private val externalScope: CoroutineScope,
    private val dustRemoteSource: DustRemoteSource,
    private val dustDataSource: DustDao
) : DustRepository {

    override suspend fun syncDustList(numOfRows: Int, pageNo: Int, sidoName: String): Boolean {
        val networkResult = dustRemoteSource.fetchDustList(numOfRows = numOfRows, pageNo = pageNo, sidoName = sidoName)
        networkResult.response.body.items.map { item: Item -> dustDataSource.updateDust(item.asEntity()) }
        return true
    }
}
