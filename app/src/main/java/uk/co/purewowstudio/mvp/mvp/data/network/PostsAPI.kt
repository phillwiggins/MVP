package uk.co.purewowstudio.mvp.mvp.data.network

import io.reactivex.Observable
import retrofit2.http.GET
import uk.co.purewowstudio.mvp.mvp.data.models.Posts

interface PostsAPI {

    @GET("posts/")
    fun getPosts(): Observable<List<Posts>>
}