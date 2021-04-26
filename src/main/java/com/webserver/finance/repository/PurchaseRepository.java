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
            value = "SELECT 'Всего' as category, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE DATE(date) = current_date " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "UNION " +
                    "SELECT productcategories.name, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE DATE(date) = current_date " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "GROUP BY productcategories.name;",
            nativeQuery = true)
    List<Object[]> todayTotalPurchases(@Param("id_client") Integer id);

    @Query(
            value = "SELECT 'Всего' as category, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(Week FROM date) = EXTRACT(Week FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "UNION " +
                    "SELECT productcategories.name, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(Week FROM date) = EXTRACT(Week FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "GROUP BY productcategories.name;",
            nativeQuery = true)
    List<Object[]> weekTotalPurchases(@Param("id_client") Integer id);

    @Query(
            value = "SELECT 'Всего' as category, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(MONTH FROM date) = EXTRACT(MONTH FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "UNION " +
                    "SELECT productcategories.name, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(MONTH FROM date) = EXTRACT(MONTH FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "GROUP BY productcategories.name;",
            nativeQuery = true)
    List<Object[]> monthTotalPurchases(@Param("id_client") Integer id);

    @Query(
            value = "SELECT 'Всего' as category, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "UNION " +
                    "SELECT productcategories.name, SUM(total) " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "GROUP BY productcategories.name;",
            nativeQuery = true)
    List<Object[]> yearTotalPurchases(@Param("id_client") Integer id);

    @Query(
            value = "SELECT SUM(query_in.total) AS total " +
                    "FROM " +
                    "(SELECT -SUM(total) AS total " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE DATE(date) = current_date " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "UNION " +
                    "SELECT SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE DATE(date) = current_date " +
                    "AND incomecategories.clients = :id_client) AS query_in;",
            nativeQuery = true)
    List<Object[]> balanceToday(@Param("id_client") Integer id);

    @Query(
            value = "SELECT SUM(query_in.total) AS total " +
                    "FROM " +
                    "(SELECT -SUM(total) AS total " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(Week FROM date) = EXTRACT(Week FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "UNION " +
                    "SELECT SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE EXTRACT(Week FROM date) = EXTRACT(Week FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND incomecategories.clients = :id_client) AS query_in;",
            nativeQuery = true)
    List<Object[]> balanceWeek(@Param("id_client") Integer id);

    @Query(
            value = "SELECT SUM(query_in.total) AS total " +
                    "FROM " +
                    "(SELECT -SUM(total) AS total " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(MONTH FROM date) = EXTRACT(MONTH FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "UNION " +
                    "SELECT SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE EXTRACT(MONTH FROM date) = EXTRACT(MONTH FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND incomecategories.clients = :id_client) AS query_in;",
            nativeQuery = true)
    List<Object[]> balanceMonth(@Param("id_client") Integer id);

    @Query(
            value = "SELECT SUM(query_in.total) AS total " +
                    "FROM " +
                    "(SELECT -SUM(total) AS total " +
                    "FROM purchases " +
                    "INNER JOIN products ON purchases.product_id = products.id " +
                    "INNER JOIN productcategories ON products.category_id = productcategories.id " +
                    "WHERE EXTRACT(YEAR FROM date) = EXTRACT(YEAR FROM current_timestamp) " +
                    "AND productcategories.authorizationclients_id = :id_client " +
                    "UNION " +
                    "SELECT SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE EXTRACT(YEAR FROM date) = EXTRACT(YEAR FROM current_timestamp) " +
                    "AND incomecategories.clients = :id_client) AS query_in;",
            nativeQuery = true)
    List<Object[]> balanceYear(@Param("id_client") Integer id);
}
