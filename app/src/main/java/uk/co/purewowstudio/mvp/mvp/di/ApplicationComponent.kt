package uk.co.purewowstudio.mvp.mvp.di

import dagger.Component
import uk.co.purewowstudio.mvp.mvp.ui.MainActivity
import uk.co.purewowstudio.mvp.mvp.MainApplication
import uk.co.purewowstudio.mvp.mvp.data.viewmodels.ViewModelModule
import uk.co.purewowstudio.mvp.mvp.di.modules.ApiModule
import uk.co.purewowstudio.mvp.mvp.di.modules.ApplicationModule
import uk.co.purewowstudio.mvp.mvp.di.modules.NetworkModule
import javax.inject.Singleton

@Component(modules = [(NetworkModule::class), (ApiModule::class), (ViewModelModule::class), (ApplicationModule::class)])
@Singleton
interface ApplicationComponent {
    fun inject(mainApplication: MainApplication)
    fun inject(mainActivity: MainActivity)
}