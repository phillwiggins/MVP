package uk.co.purewowstudio.mvp.mvp.data.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uk.co.purewowstudio.mvp.mvp.data.models.Posts
import javax.inject.Inject

class PostsViewModel @Inject constructor(application: Application,
                                         private val postsObservable: Observable<List<Posts>>) : AndroidViewModel(application) {

    private var posts = MutableLiveData<List<Posts>>()

    private fun watchPosts() {
        postsObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe { listOfPosts ->
                    if (listOfPosts != null) setPosts(listOfPosts)
                }
    }

    private fun setPosts(posts: List<Posts>) {
        this.posts.postValue(posts)
    }

    fun getPosts(): LiveData<List<Posts>> {
        return this.posts
    }

    init {
        watchPosts()
    }
}