package uk.co.purewowstudio.mvp.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Retrofit
import uk.co.purewowstudio.mvp.mvp.data.network.PostsController
import uk.co.purewowstudio.mvp.mvp.di.ApplicationComponent
import uk.co.purewowstudio.mvp.mvp.utils.logDebug
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    private lateinit var mRetroFit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mComponent = DaggerApplicationComponent.builder().build()
        mComponent.inject(this)
        mComponent.let { _ ->

            logDebug(LOG_TAG, mRetroFit.baseUrl().toString())
            val postsController = PostsController()
            postsController.start(mRetroFit)
        }
    }

    companion object {

        @JvmStatic
        lateinit var mComponent: ApplicationComponent
        val LOG_TAG = MainActivity::class.java.simpleName
    }
}
