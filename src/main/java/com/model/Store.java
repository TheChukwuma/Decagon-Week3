package com.model;

import enums.ProductStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Store {
    HashMap<String, List<Product>> store = new HashMap<>();

    public void setStore() throws IOException {
        List<Product> tmp = new ArrayList<>();

        HashMap<String, List<Product>> hashMap = new HashMap<>();

        String filepath = "src/main/resources/FoodSales.csv";
        File file = new File(filepath);

        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);

        String line = "";
        int iteration = 0;
        while ((line = br.readLine()) != null){
            if (iteration == 0){ // this is to skip the heading of the CSV file
                iteration++;
                continue;
            }
            String[] sheetRow = line.split(",");
            Product product = new Product(sheetRow[3], sheetRow[4], Long.valueOf(sheetRow[5]), Double.valueOf(sheetRow[6]));

            boolean found = false;

            if(product.getProductQuantity() > 0){
                product.setProductStatus(ProductStatus.INSTOCK);
            }else product.setProductStatus(ProductStatus.OUTOFSTOCK);

            for (Product myProduct : tmp) {
                if (product.getProductName().equalsIgnoreCase(myProduct.getProductName())){
                    myProduct.setProductQuantity(myProduct.getProductQuantity() + product.getProductQuantity());
                    found = true;
                }
            }
            if (!found){
                tmp.add(product);
            }
        }

        for (Product product : tmp){
           if (hashMap.containsKey(product.getProductCategory())){
               hashMap.get(product.getProductCategory()).add(product);
           }
           else {
               List<Product> proTmp = new ArrayList<>();
               proTmp.add(product);
               hashMap.put(product.getProductCategory(), proTmp);
           }
       } this.store = hashMap;

    }

    public HashMap<String, List<Product>> getStore(){
        return store;
    }
    @Override
    public String toString()
    {
        return "Store{" +
                "productList=" + store +
                '}';
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return getStore().equals(store.getStore());
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(getStore());
    }

}
