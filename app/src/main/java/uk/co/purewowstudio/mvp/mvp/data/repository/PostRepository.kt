package uk.co.purewowstudio.mvp.mvp.data.repository

import android.arch.lifecycle.LiveData
import uk.co.purewowstudio.mvp.mvp.data.models.Posts

interface PostRepository {
    fun findById(id: Long): LiveData<Posts>
    fun findAll(): LiveData<List<Posts>>
    fun insert(post: Posts): Long
    fun delete(post: Posts): Long
}