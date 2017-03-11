package com.bubelov.coins.dagger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bubelov.coins.database.DbHelper;
import com.bubelov.coins.service.DatabaseSync;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Igor Bubelov
 */

@Module
public class DatabaseModule {
    @Provides
    @Singleton
    SQLiteDatabase database(Context context) {
        return new DbHelper(context).getWritableDatabase();
    }

    @Provides
    @Singleton
    DatabaseSync databaseSync() {
        return new DatabaseSync();
    }
}