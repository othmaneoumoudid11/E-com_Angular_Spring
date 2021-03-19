package com.example.othmane;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.othmane.dao.CategoryRepository;
import com.example.othmane.dao.ProductRepository;
import com.example.othmane.entities.Category;
import com.example.othmane.entities.Product;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class EComAppApplication implements CommandLineRunner {

	@Autowired
	public CategoryRepository categoryRepository;
	@Autowired
	public ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EComAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		categoryRepository.save(new Category(null,"Computers",null,null));
		categoryRepository.save(new Category(null,"Printers",null,null));
		categoryRepository.save(new Category(null,"Smart phones",null,null));
		Random rnd = new Random();
		categoryRepository.findAll().forEach(c->{
			for (int i = 0; i < 10 ; i++) {
				Product p = new Product();
				p.setName(RandomString.make(16));
				p.setCurrentPrice(100+rnd.nextInt(10000));
				p.setAvailable(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setCategory(c);
				productRepository.save(p);
			}
		});
	}

}
