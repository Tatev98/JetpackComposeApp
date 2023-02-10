package com.example.jetpackcomposeapp.data.di


import com.example.jetpackcomposeapp.data.local.HomeRepositoryImp
import com.example.jetpackcomposeapp.data.local.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

//creates repository using di
@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(impl: HomeRepositoryImp): HomeRepository
}

