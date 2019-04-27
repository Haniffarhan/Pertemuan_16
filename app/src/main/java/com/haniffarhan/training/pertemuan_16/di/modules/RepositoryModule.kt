package com.haniffarhan.training.pertemuan_16.di.modules

import com.haniffarhan.training.pertemuan_16.api.Catalog
import com.haniffarhan.training.pertemuan_16.repo.CatalogRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideCatalogRepo(api: Catalog) : CatalogRepository{
        return CatalogRepository(api)
    }
}