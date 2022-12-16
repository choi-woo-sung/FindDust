package com.ddd.pollpoll.core.data.repositoryImp

import com.ddd.pollpoll.core.data.repository.DustRepository
import com.ddd.pollpoll.network.remotesource.DustRemoteSource
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class DustRepositoryImp @Inject constructor(
    private val externalScope: CoroutineScope,
    private val dustRemoteSource: DustRemoteSource
) : DustRepository {

    override suspend fun getDustList(numOfRows: Int, pageNo: Int, sidoName: String) {
        dustRemoteSource.fetchDustList(numOfRows = 0, pageNo = 0, sidoName = "")
    }
}
