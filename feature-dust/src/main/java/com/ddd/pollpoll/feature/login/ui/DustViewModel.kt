/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ddd.pollpoll.feature.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddd.pollpoll.core.data.repository.DustRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DustViewModel @Inject constructor(
    private val dustRepository: DustRepository
) : ViewModel() {

    private var _uiState: MutableStateFlow<DustUiState> =
        MutableStateFlow<DustUiState>(DustUiState.Loading)

    val uiState = _uiState.asStateFlow()

    fun addList(numOfRows: Int, pageNo: Int, sidoName: String) {
        viewModelScope.launch {
            dustRepository.getDustList(numOfRows, pageNo, sidoName).map {
                map
            }
        }
    }
}

sealed interface DustUiState {
    object Loading : DustUiState
    data class Error(val throwable: Throwable) : DustUiState
    data class Success(val data: List<String>) : DustUiState
}