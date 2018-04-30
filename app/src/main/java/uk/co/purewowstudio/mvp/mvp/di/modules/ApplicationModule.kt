package uk.co.purewowstudio.mvp.mvp.di.modules

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import uk.co.purewowstudio.mvp.mvp.MainApplication
import javax.inject.Singleton

@Module
class ApplicationModule(private var application: MainApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Application = application
}