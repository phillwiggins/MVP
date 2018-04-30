package uk.co.purewowstudio.mvp.mvp.data.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass
import android.app.Application
import uk.co.purewowstudio.mvp.mvp.MainApplication


@Singleton
class CustomViewModelFactory
@Inject constructor(
        private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = creators[modelClass]?.get() as T
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: CustomViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    internal abstract fun postListViewModel(viewModel: PostsViewModel): ViewModel
}