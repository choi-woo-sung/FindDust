package com.ddd.pollpoll.network.di

import com.ddd.pollpoll.network.remotesource.DustRemoteSource
import com.ddd.pollpoll.network.remotesource.DustRemoteSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RemoteModule {

    @Singleton
    @Binds
    fun bindsDustRemoteSource(dustRemoteSourceImp: DustRemoteSourceImp): DustRemoteSource
}