package com.webserver.finance.controllers;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.webserver.finance.models.AuthorizationClient;
import com.webserver.finance.models.Product;
import com.webserver.finance.models.ProductCategory;
import com.webserver.finance.models.Purchase;
import com.webserver.finance.service.Service.PurchaseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PurchaseController.class)
class PurchaseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PurchaseService service;
    private Purchase p;

    private void createTestPurchases() throws ParseException {
        AuthorizationClient authorizationClient = new AuthorizationClient();
        authorizationClient.setId(86);
        authorizationClient.setUsername("mur");
        authorizationClient.setPassword("mur");
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(91);
        productCategory.setName("Здоровье");
        productCategory.setAuthorizationClientCategory(authorizationClient);
        Product product = new Product();
        product.setId(92);
        product.setName("Стоматолог");
        product.setProductCategory(productCategory);
        p = new Purchase(68, new SimpleDateFormat("dd.MM.yyyy").parse("08.03.2021"),100D,"Тест read",product);
        service.create(p);
    }

    @Test
    void create() throws Exception {
        Product icecream = new Product();
        String json = "{\n" +
                "        \"id\": 93,\n" +
                "        \"date\": \"11.05.2021\",\n" +
                "        \"total\": 1000.0,\n" +
                "        \"description\": \"Тест\",\n" +
                "        \"product\": {\n" +
                "            \"id\": 92,\n" +
                "            \"name\": \"Стоматолог\",\n" +
                "            \"productCategory\": {\n" +
                "                \"id\": 91,\n" +
                "                \"name\": \"Здоровье\",\n" +
                "                \"authorizationClientCategory\": {\n" +
                "                    \"id\": 86,\n" +
                "                    \"username\": \"mur\",\n" +
                "                    \"password\": \"mur\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }";
        Purchase p1 = new Purchase(1,new SimpleDateFormat("dd.MM.yyyy").parse("08.03.2021") ,10000D,"Тест пройден",icecream);
        mockMvc.perform(post("/purchases")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void read() throws Exception {

        Product icecream = new Product();
        Product car = new Product();

        when(service.readAll()).thenReturn(Arrays.asList(
                new Purchase(1,new SimpleDateFormat("dd.MM.yyyy").parse("08.03.2021") ,10000D,"Тест пройден",icecream),
                new Purchase(2,new SimpleDateFormat("dd.MM.yyyy").parse("07.05.2021") ,500D,"Тест2 пройден",car)
                ));
        mockMvc.perform(get("/purchases").contentType("UTF-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[*].id",containsInAnyOrder(1,2)))
                .andExpect(jsonPath("$[*].date",containsInAnyOrder("07.03.2021","06.05.2021")))
                .andExpect(jsonPath("$[*].total",containsInAnyOrder(10000.0,500.0)))
                .andExpect(jsonPath("$[*].description",containsInAnyOrder("Тест пройден","Тест2 пройден")));
    }

    @Test
    void update() throws Exception {
        createTestPurchases();
        String json = "{\n" +
                "        \"id\": 68,\n" +
                "        \"date\": \"11.05.2021\",\n" +
                "        \"total\": 2000.0,\n" +
                "        \"description\": \"Тест\",\n" +
                "        \"product\": {\n" +
                "            \"id\": 92,\n" +
                "            \"name\": \"Стоматолог\",\n" +
                "            \"productCategory\": {\n" +
                "                \"id\": 91,\n" +
                "                \"name\": \"Здоровье\",\n" +
                "                \"authorizationClientCategory\": {\n" +
                "                    \"id\": 86,\n" +
                "                    \"username\": \"mur\",\n" +
                "                    \"password\": \"mur\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }";
        Product car = new Product();
        when(service.update(p, p.getId())).thenReturn(true);
        mockMvc.perform(put("/purchases/" + p.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isNotModified());

    }

    @Test
    void deleteTest()throws Exception {
        when(service.delete(1)).thenReturn(true);
        mockMvc.perform(delete("/purchases/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        when(service.delete(2)).thenReturn(false);
        mockMvc.perform(delete("/purchases/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotModified());
    }

    @Test
    void readPurchases() throws Exception {
        AuthorizationClient authorizationClient = new AuthorizationClient();
        authorizationClient.setId(86);
        authorizationClient.setUsername("mur");
        authorizationClient.setPassword("mur");
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(91);
        productCategory.setName("Здоровье");
        productCategory.setAuthorizationClientCategory(authorizationClient);
        Product product = new Product();
        product.setId(92);
        product.setName("Стоматолог");
        product.setProductCategory(productCategory);
        Purchase p = new Purchase(68, new SimpleDateFormat("dd.MM.yyyy").parse("08.03.2021"),100D,"Тест read",product);
        when(service.readbyclient(anyInt())).thenReturn(Arrays.asList(p));
        mockMvc.perform(get("/purchases/"+p.getProduct().getProductCategory().getAuthorizationClientCategory().getId().toString()).contentType("UTF-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[*].date",containsInAnyOrder("07.03.2021")))
                .andExpect(jsonPath("$[*].total",containsInAnyOrder(100.0)))
                .andExpect(jsonPath("$[*].description",containsInAnyOrder("Тест read")));
    }
    @Test
    void readInfo() throws Exception {
        AuthorizationClient authorizationClient = new AuthorizationClient();
        authorizationClient.setId(86);
        authorizationClient.setUsername("mur");
        authorizationClient.setPassword("mur");
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(91);
        productCategory.setName("Здоровье");
        productCategory.setAuthorizationClientCategory(authorizationClient);
        Product product = new Product();
        product.setId(92);
        product.setName("Стоматолог");
        product.setProductCategory(productCategory);
        Purchase p = new Purchase(68, new SimpleDateFormat("dd.MM.yyyy").parse("08.03.2021"),100D,"Тест read",product);
        when(service.readbyid(anyInt())).thenReturn(p);
        mockMvc.perform(get("/purchases/info/"+p.getId().toString()).contentType("UTF-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(p.getId())))
                .andExpect(jsonPath("$.date",is("07.03.2021")))
                .andExpect(jsonPath("$.total",is(100.0)))
                .andExpect(jsonPath("$.description",is("Тест read")));;
    }
}