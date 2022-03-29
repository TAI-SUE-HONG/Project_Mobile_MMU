package Data;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import model.Cart;

@Dao
public interface CartDao {
    @Query("SELECT EXISTS(SELECT * FROM Cart WHERE Name=:name)")
    boolean getCart(String name);

    @Query("SELECT * FROM Cart")
    List<Cart> loadAllProduct();

    @Insert
    void insert(Cart cart);

    @Update
    void update(Cart cart);

    @Delete
    void delete(Cart cart);
}

