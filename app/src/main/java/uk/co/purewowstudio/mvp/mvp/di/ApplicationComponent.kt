package uk.co.purewowstudio.mvp.mvp.di

import dagger.Component
import uk.co.purewowstudio.mvp.mvp.data.repository.PostRepository
import uk.co.purewowstudio.mvp.mvp.data.storage.AppDatabase
import uk.co.purewowstudio.mvp.mvp.data.storage.PostDao
import uk.co.purewowstudio.mvp.mvp.data.viewmodels.ViewModelModule
import uk.co.purewowstudio.mvp.mvp.di.modules.ApiModule
import uk.co.purewowstudio.mvp.mvp.di.modules.ApplicationModule
import uk.co.purewowstudio.mvp.mvp.di.modules.NetworkModule
import uk.co.purewowstudio.mvp.mvp.di.modules.RoomModule
import uk.co.purewowstudio.mvp.mvp.ui.MainActivity
import javax.inject.Singleton


@Component(modules = [(NetworkModule::class), (ApiModule::class), (ViewModelModule::class), (ApplicationModule::class), (RoomModule::class)])
@Singleton
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun postDao(): PostDao
    fun roomDB(): AppDatabase
    fun postRepository(): PostRepository
}