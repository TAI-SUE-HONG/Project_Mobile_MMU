package Data;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import model.Payment;

@Dao
public interface PaymentDao {
    @Query("SELECT EXISTS(SELECT * FROM Payment WHERE Name=:name)")
    boolean getPayment(String name);

    @Query("SELECT * FROM Payment")
    List<Payment> loadAllDetails();

    @Insert
    void insert(Payment Payment);

    @Update
    void update(Payment Payment);

    @Delete
    void delete(Payment Payment);
}

