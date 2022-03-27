package com.emart.disco;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {database_product_catalog.class}, version = 1)
public abstract class ProductDiscoDatabase extends RoomDatabase{
    public abstract ProductDao productDao();
    private static ProductDiscoDatabase INSTANCE;
    static ProductDiscoDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null) {
            synchronized (ProductDiscoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    ProductDiscoDatabase.class,
                                    "product_database").build
                                    ();
                }
            }
        }
        return INSTANCE;
    }
}
