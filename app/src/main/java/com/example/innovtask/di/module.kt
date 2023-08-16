package com.example.innovtask.di

import com.example.innovtask.data.remote.MockRemoteSource
import com.example.innovtask.data.remote.RemoteSource
import com.example.innovtask.data.repository.ConcreteRepository
import com.example.innovtask.domain.repository.IRepository
import com.example.innovtask.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory<RemoteSource> { MockRemoteSource(androidContext()) }
    single<IRepository> { ConcreteRepository(get()) }
    factory { MainViewModel(get()) }
}