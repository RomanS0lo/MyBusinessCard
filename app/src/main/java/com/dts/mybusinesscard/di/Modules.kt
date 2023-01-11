package com.dts.mybusinesscard.di

import com.dts.mybusinesscard.ui.main.MainViewModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Module that responsible for logic
val app = module {
    single { GsonBuilder().create() }
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
//    single {
//        Retrofit.Builder()
//            .baseUrl("https://data.cityofnewyork.us/resource/")
//            .addConverterFactory(GsonConverterFactory.create(get()))
//            .client(get())
//            .build()
//    }
//    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }
//    single { RestApiService(get()) }
}

//Module that  responsible for view models
val viewModels = module {
    viewModel { MainViewModel() }
}
