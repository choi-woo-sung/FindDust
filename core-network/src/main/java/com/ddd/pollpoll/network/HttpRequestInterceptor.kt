package com.ddd.pollpoll.network

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url()).build()
        Timber.d(request.toString())
        val response = chain.proceed(request)
        Timber.d(response.toString())
        return response
    }
}
