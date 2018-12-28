package com.devil.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.devil.configuration.DBConfiguration;
import com.devil.dao.ProductDao;
import com.devil.dao.ProductDaoImpl;
import com.devil.models.Category;
import com.devil.models.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );      
        ApplicationContext context=
        	      new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
        	      ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
        	      Category category = new Category();
        	      category.setCategoryId(102);
        	      Product product = productDao.getProduct(6);
        	      product.setDescription("description6");
        	      product.setPrice(300);
        	      product.setProductName("Product6");
        	      product.setQuantity(100);
        	      product.setCategory(category);
        	      productDao.update(product);
        	      
        	      
        	     /* Product product=productDao.getProduct(1);
        	      System.out.println(product);
        	      if(product!=null){
        	      System.out.println(product.getId());
        	      System.out.println(product.getProductName());
        	      System.out.println(product.getDescription());
        	      System.out.println(product.getPrice());
        	      System.out.println(product.getQuantity());
        	      }else{
        	    	  System.out.println("Product id 7 not found");
        	      }*/
        	      
        	      /* List<Product> products=productDao.getAllProducts();
        	      System.out.println(products);
        	      System.out.println(products.size());*/
        
    }
}

