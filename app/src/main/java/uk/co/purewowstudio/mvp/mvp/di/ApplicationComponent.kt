package uk.co.purewowstudio.mvp.mvp.di

import dagger.Component
import uk.co.purewowstudio.mvp.mvp.MainActivity
import uk.co.purewowstudio.mvp.mvp.MainApplication
import javax.inject.Singleton

@Component(modules = [(NetworkModule::class)])
@Singleton
interface ApplicationComponent {
    fun inject(mainApplication: MainApplication)
    fun inject(mainActivity: MainActivity)
}