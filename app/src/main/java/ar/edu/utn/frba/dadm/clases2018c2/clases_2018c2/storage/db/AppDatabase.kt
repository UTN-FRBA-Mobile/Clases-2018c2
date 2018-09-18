package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.storage.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.storage.db.daos.FavoriteMoviesDao
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.storage.db.daos.SearchesDao
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.storage.db.entities.FavoriteMovie
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.storage.db.entities.Search

@Database(entities = [(Search::class), (FavoriteMovie::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieSearchDao(): SearchesDao
    abstract fun favoriteMoviesDao(): FavoriteMoviesDao

    companion object {
        private var db: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (db == null) {
                db = Room.databaseBuilder(context, AppDatabase::class.java, "database-2018c2").build()
            }

            return db as AppDatabase
        }
    }
}