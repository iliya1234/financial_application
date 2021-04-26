package com.webserver.finance.repository;

import com.webserver.finance.models.Income;
import com.webserver.finance.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Integer> {
    List<Income> findByIncomeProductIncomeCategoryClientsIdOrderByDateDesc(int id);
    Income findById(int id);

    @Query(
            value = "SELECT 'Всего' as category, SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE DATE(date) = current_date " +
                    "AND incomecategories.clients = :id_client " +
                    "UNION  " +
                    "SELECT incomecategories.name, SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE DATE(date) = current_date " +
                    "AND incomecategories.clients = :id_client " +
                    "GROUP BY incomecategories.name;",
            nativeQuery = true)
    List<Object[]> dayTotalIncomes(@Param("id_client") Integer id);
    @Query(
            value = "SELECT 'Всего' as category, SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE EXTRACT(WEEK FROM date) = EXTRACT(WEEK FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND incomecategories.clients = :id_client " +
                    "UNION  " +
                    "SELECT incomecategories.name, SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE EXTRACT(WEEK FROM date) = EXTRACT(WEEK FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND incomecategories.clients = :id_client " +
                    "GROUP BY incomecategories.name;",
            nativeQuery = true)
    List<Object[]> weekTotalIncomes(@Param("id_client") Integer id);
    @Query(
            value = "SELECT 'Всего' as category, SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE EXTRACT(MONTH FROM date) = EXTRACT(MONTH FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND incomecategories.clients = :id_client " +
                    "UNION  " +
                    "SELECT incomecategories.name, SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE EXTRACT(MONTH FROM date) = EXTRACT(MONTH FROM current_timestamp) " +
                    "AND EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND incomecategories.clients = :id_client " +
                    "GROUP BY incomecategories.name;",
            nativeQuery = true)
    List<Object[]> monthTotalIncomes(@Param("id_client") Integer id);
    @Query(
            value = "SELECT 'Всего' as category, SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND incomecategories.clients = :id_client " +
                    "UNION  " +
                    "SELECT incomecategories.name, SUM(total) " +
                    "FROM incomes " +
                    "INNER JOIN incomeproducts ON incomes.incomeproduct_id = incomeproducts.id " +
                    "INNER JOIN incomecategories ON incomeproducts.category_id = incomecategories.id " +
                    "WHERE EXTRACT(Year FROM date) = EXTRACT(Year FROM current_timestamp) " +
                    "AND incomecategories.clients = :id_client " +
                    "GROUP BY incomecategories.name;",
            nativeQuery = true)
    List<Object[]> yearTotalIncomes(@Param("id_client") Integer id);
}
