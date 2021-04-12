package com.yyusufsefa.videogamesapp.di

import com.yyusufsefa.videogamesapp.BuildConfig
import com.yyusufsefa.videogamesapp.network.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(
                Interceptor { chain ->
                    val request = chain.request()
                        .newBuilder()
                        .addHeader(
                            "x-rapidapi-key",
                            "c26b205fa2msh4d347d5bf67607cp1b5036jsn0f1e6a63a3e9"
                        )
                        .build()
                    chain.proceed(request)
                }
            ).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit
        .Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://rawg-video-games-database.p.rapidapi.com/")
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
}