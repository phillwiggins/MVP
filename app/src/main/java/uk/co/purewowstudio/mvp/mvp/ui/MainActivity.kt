package uk.co.purewowstudio.mvp.mvp.ui

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import uk.co.purewowstudio.mvp.mvp.MainApplication
import uk.co.purewowstudio.mvp.mvp.R
import uk.co.purewowstudio.mvp.mvp.data.models.Posts
import uk.co.purewowstudio.mvp.mvp.data.viewmodels.PostsViewModel
import uk.co.purewowstudio.mvp.mvp.di.ApplicationComponent
import uk.co.purewowstudio.mvp.mvp.di.modules.ApplicationModule
import uk.co.purewowstudio.mvp.mvp.di.DaggerApplicationComponent
import uk.co.purewowstudio.mvp.mvp.utils.logDebug
import uk.co.purewowstudio.mvp.mvp.utils.observe
import uk.co.purewowstudio.mvp.mvp.utils.withViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this.application as MainApplication))
                .build()

        mComponent?.inject(this)

        withViewModel<PostsViewModel>(viewModelFactory) {
            observe(getPosts(), ::updatePosts)
        }
    }

    private fun updatePosts(posts: List<Posts>?) {
        posts?.forEach { post ->
            logDebug(LOG_TAG, post.title)
        }
    }

    companion object {

        @JvmStatic
        var mComponent: ApplicationComponent? = null
        val LOG_TAG: String = MainActivity::class.java.simpleName
    }
}
