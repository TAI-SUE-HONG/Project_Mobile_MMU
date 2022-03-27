package com.emart.disco;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao
public interface ProductDao {
    @Insert
    void insertProduct(database_product_catalog product);
    @Query("SELECT * FROM database_product_catalog WHERE productName = :name")
    List<database_product_catalog> findProduct(String name);
    @Query("DELETE FROM database_product_catalog WHERE productName = :name")
    void deleteProduct(String name);
    @Query("SELECT * FROM database_product_catalog")
    LiveData<List<database_product_catalog>> getAllProducts();
}
    public void insertProduct(database_product_catalog newproduct) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            productDao.insertProduct(newproduct);
        });
        executor.shutdown();
    }
    public void deleteProduct(String name) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            productDao.deleteProduct(name);
        });
        executor.shutdown();
    }
    public void findProduct(String name) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            results = productDao.findProduct(name);
            handler.sendEmptyMessage(0);
        });
        executor.shutdown();
    }
