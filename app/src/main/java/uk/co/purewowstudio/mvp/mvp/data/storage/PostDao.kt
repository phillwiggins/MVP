package uk.co.purewowstudio.mvp.mvp.data.storage

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import uk.co.purewowstudio.mvp.mvp.data.models.Posts
import uk.co.purewowstudio.mvp.mvp.data.models.Posts.Companion.POST_ID
import uk.co.purewowstudio.mvp.mvp.data.models.Posts.Companion.POST_TABLE_NAME

@Dao
interface PostDao {

    @Query("select Count(*) from $POST_TABLE_NAME")
    fun countAll(): Int

    @Query("select * from $POST_TABLE_NAME")
    fun findAll(): LiveData<List<Posts>>

    @Query("select * from $POST_TABLE_NAME where $POST_ID = :id")
    fun findById(id: Long): LiveData<Posts>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: Posts): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(post: Posts): Long

    @Delete
    fun delete(post: Posts): Long

    @Query("DELETE FROM $POST_TABLE_NAME")
    fun nukeTable()
}