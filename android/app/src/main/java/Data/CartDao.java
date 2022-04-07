package Data;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
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

    @Query("SELECT userName FROM User")
    String getName();

    @Query("DELETE FROM Cart")
    void delete();


    @Query("DELETE FROM Cart WHERE Name = :name")
    void deleteCart(String name);

    @Query("UPDATE Cart SET Quantity=:Quantity WHERE Name= :name " )
    void update(String name, int Quantity);

    @Insert
    void insert(Cart cart);

    @Update
    void update(Cart cart);

    @Query("SELECT SUM(Price*Quantity) FROM Cart ")
    double getGrossPayment();
}

