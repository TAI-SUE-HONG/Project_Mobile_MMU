package Data;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import model.Cart;

@Database(entities = {Cart.class}, version = 1, exportSchema = false)
public abstract  class CartDatabase extends RoomDatabase {

    public abstract CartDao getCartDao();
}