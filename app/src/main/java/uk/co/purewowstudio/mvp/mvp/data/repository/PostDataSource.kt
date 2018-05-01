package uk.co.purewowstudio.mvp.mvp.data.repository

import android.arch.lifecycle.LiveData
import uk.co.purewowstudio.mvp.mvp.data.models.Posts
import uk.co.purewowstudio.mvp.mvp.data.storage.PostDao
import javax.inject.Inject

class PostDataSource @Inject
constructor(private val postDao: PostDao) : PostRepository {

    override fun findById(id: Long): LiveData<Posts> {
        return postDao.findById(id)
    }

    override fun findAll(): LiveData<List<Posts>> {
        return postDao.findAll()
    }

    override fun insert(post: Posts): Long {
        return postDao.insert(post)
    }

    override fun delete(post: Posts): Long {
        return postDao.delete(post)
    }
}