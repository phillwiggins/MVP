package uk.co.purewowstudio.mvp.mvp.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import uk.co.purewowstudio.mvp.mvp.data.repository.PostDataSource
import uk.co.purewowstudio.mvp.mvp.data.repository.PostRepository
import uk.co.purewowstudio.mvp.mvp.data.storage.AppDatabase
import uk.co.purewowstudio.mvp.mvp.data.storage.PostDao
import javax.inject.Singleton

@Module
class RoomModule(private var application: Application) {

    private var appDatabase: AppDatabase? = null

    init {
        appDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "demoDb").build()
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return appDatabase!!
    }

    @Singleton
    @Provides
    fun providesPostDao(demoDatabase: AppDatabase): PostDao {
        return demoDatabase.postDao
    }

    @Singleton
    @Provides
    fun postRepository(postDao: PostDao): PostRepository {
        return PostDataSource(postDao)
    }
}