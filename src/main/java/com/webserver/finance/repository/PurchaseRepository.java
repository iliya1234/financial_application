package com.webserver.finance.repository;

import com.webserver.finance.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
    //поиск по определенному клиенту, вывод продукта по имени
    List<Purchase> findByProductProductCategoryAuthorizationClientCategoryIdOrderByDateDesc(int id);

    Purchase findById(int id);


    @Query(
            value = "SELECT productcategories.name, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(DAY FROM date) = EXTRACT(DAY FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client "+
                    "GROUP BY productcategories.name;",
            nativeQuery = true)
    List<Object[]> todayTotalPurchases(@Param("id_client") Integer id);

    @Query(
            value = "SELECT productcategories.name, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(WEEK FROM date) = EXTRACT(WEEK FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client "+
                    "GROUP BY productcategories.name;",
            nativeQuery = true)
    List<Object[]> weekTotalPurchases(@Param("id_client") Integer id);

    @Query(
            value = "SELECT productcategories.name, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(MONTH FROM date) = EXTRACT(MONTH FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client "+
                    "GROUP BY productcategories.name;",
            nativeQuery = true)
    List<Object[]> monthTotalPurchases(@Param("id_client") Integer id);

    @Query(
            value = "SELECT productcategories.name, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(YEAR FROM date) = EXTRACT(YEAR FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client "+
                    "GROUP BY productcategories.name;",
            nativeQuery = true)
    List<Object[]> yearTotalPurchases(@Param("id_client") Integer id);
}
