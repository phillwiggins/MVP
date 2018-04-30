package uk.co.purewowstudio.mvp.mvp.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import retrofit2.Retrofit
import uk.co.purewowstudio.mvp.mvp.data.models.Posts
import uk.co.purewowstudio.mvp.mvp.data.network.PostsAPI
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun getPostsApi(retrofit: Retrofit): Observable<List<Posts>> {
        val postsApi = retrofit.create(PostsAPI::class.java)
        return postsApi.getPosts()
    }
}