package Data;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import model.Cart;
import model.Payment;
import model.User;

@Database(entities = {User.class, Cart.class, Payment.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase{

    public abstract UserDao getUserDao();

    public abstract CartDao getCartDao();

    public abstract PaymentDao getPaymentDao();
}
