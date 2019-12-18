package com.example.mytestitunesnew.di

import android.content.Context
import android.net.ConnectivityManager
import com.example.mytestitunesnew.URL_BASE_API
import com.example.mytestitunesnew.data.remote.net.SongRemoteApi
import com.example.mytestitunesnew.data.remote.source.SongRemoteDatSource
import com.example.mytestitunesnew.data.repository.SongRepository
import com.example.mytestitunesnew.domain.usecase.GetSongUseCase
import com.example.mytestitunesnew.presentation.viewmodel.SongViewModel
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    /* Android Services */
    single {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    /* Retrofit */
    single {
        OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(URL_BASE_API)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(SongRemoteApi::class.java) as SongRemoteApi }


    /* Database */
  /*  single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }*/
    /* Dao Interfaces */
 //   factory { get<AppDatabase>().loginDao() }


    /* DataSource */
    factory { SongRemoteDatSource(get()) }

    /* Repositories */
    factory { SongRepository(get()) }

    /* UseCases */
    factory { GetSongUseCase(get()) }

/* View models */
    viewModel { SongViewModel(get()) }


    /* Picasso */
    single {
        Picasso.get()
    }

}