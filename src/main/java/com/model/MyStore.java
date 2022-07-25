package com.model;

import java.io.*;
import java.util.*;

public class MyStore {

    private HashMap<String, Product> productMap = new HashMap<>();
    private HashMap<String, List<String>> categoryMap = new HashMap<>();

    public MyStore() throws FileNotFoundException, IOException {}

    public HashMap<String, Product> getProductInStore (){
        return productMap;
    }

    public HashMap<String, List<String>> getProductInStoreByCategory (){
        return categoryMap;
    }

    public void readFile(String path){

        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line;

            while ((line = br.readLine()) != null) {
                String[] sheetRow = line.split(",");

                String category = sheetRow[3];
                String productName = sheetRow[4];
                Long productQuantity = Long.valueOf(sheetRow[5]);
                Double productCost = Double.valueOf(sheetRow[6]);


                if (productMap.containsKey(productName)) {
                    Product product = productMap.get(productName);
                    product.setProductQuantity(product.getProductQuantity() + productQuantity);
                } else {
                    Product product = new Product(category, productName, productQuantity, productCost);
                    productMap.put(productName, product);
                }

                if (categoryMap.containsKey(category)) {
                    if (!categoryMap.get(category).contains(productName)){
                        categoryMap.get(category).add(productName);
                    }
                } else {
                    List<String> newCategoryList = new ArrayList<>();
                    newCategoryList.add(productName);
                    categoryMap.put(category, newCategoryList);
                }

            }

            br.close();

        } catch(IOException e)
        {throw new RuntimeException(e);}

    }

}










