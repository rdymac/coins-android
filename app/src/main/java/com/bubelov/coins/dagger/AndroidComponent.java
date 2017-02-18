package com.bubelov.coins.dagger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bubelov.coins.PlacesCache;
import com.bubelov.coins.api.CoinsApi;
import com.bubelov.coins.service.DatabaseSync;
import com.bubelov.coins.util.MapMarkersCache;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Igor Bubelov
 */

@Singleton
@Component(modules = {AppContextModule.class, DatabaseModule.class, CacheModule.class, ApiModule.class, ConverterModule.class, NotificationsModule.class})
public interface AndroidComponent {
    Context context();

    SQLiteDatabase database();

    PlacesCache getPlacesCache();

    MapMarkersCache getMarkersCache();

    CoinsApi provideApi();

    DatabaseSync databaseSync();

    void inject(DatabaseSync sync);

    void inject(PlacesCache cache);
}