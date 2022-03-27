package com.emart.disco;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Application;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import androidx.lifecycle.LiveData;
public class ProductRepository {
    private final MutableLiveData<List<database_product_catalog>> searchResults =
            new MutableLiveData<>();
    private List<database_product_catalog> results;
    private final LiveData<List<database_product_catalog>> allProducts;
    private final ProductDao productDao;
    public ProductRepository(Application application) {
        database_product_catalog db;
        db = database_product_catalog.getDatabase(application);
        productDao = db.productDao();
        allProducts = productDao.getAllProducts();
    }
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override public void handleMessage(Message msg) {
            searchResults.setValue(results);
        }
    };

}
