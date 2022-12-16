package com.ddd.pollpoll.feature.login.ui;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/ddd/pollpoll/feature/login/ui/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "loginRepository", "Lcom/ddd/pollpoll/core/data/LoginRepository;", "(Lcom/ddd/pollpoll/core/data/LoginRepository;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/ddd/pollpoll/feature/login/ui/LoginUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addLogin", "", "name", "", "feature-login_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final com.ddd.pollpoll.core.data.LoginRepository loginRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.ddd.pollpoll.feature.login.ui.LoginUiState> uiState = null;
    
    @javax.inject.Inject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.ddd.pollpoll.core.data.LoginRepository loginRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.ddd.pollpoll.feature.login.ui.LoginUiState> getUiState() {
        return null;
    }
    
    public final void addLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
}