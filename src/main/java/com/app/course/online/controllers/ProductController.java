package com.app.course.online.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.course.online.product.Product;
import com.app.course.online.product.ProductRepository;
import com.app.course.online.product.ProductWrapper;
import com.app.course.online.product.UserProductMap;
import com.app.course.online.product.UserProductMapRepository;
import com.app.course.online.user.AuthorizationImitation;
import com.google.gson.Gson;

@RestController
public class ProductController
{
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserProductMapRepository userProductMap;
	
	@GetMapping(value = "/getAllProducts")
	@CrossOrigin
	public String getAllProducts()
	{
		if(productRepository.findAll().isEmpty())
			fillProductTable();
		
		if(AuthorizationImitation.getUser() == null)
			return "Zaloguj się.";
		
		List<Product> products = productRepository.findAll();
		
		List<ProductWrapper> productWrappers = new ArrayList<ProductWrapper>();
		products.forEach(p -> productWrappers.add(new ProductWrapper(p)));
		
		return new Gson().toJson(productWrappers);
	}
	
	@GetMapping(value = "/getAllUserProducts")
	@CrossOrigin
	public String getAllUserProducts()
	{
		if(productRepository.findAll().isEmpty())
			fillProductTable();
		
		if(AuthorizationImitation.getUser() == null)
			return "Zaloguj się.";
		
		List<UserProductMap> upm = userProductMap.findAll();
		List<Product> products = new ArrayList<Product>();
		for(UserProductMap u : upm)
		{
			if(u.getUser().equals(AuthorizationImitation.getUser()))
				products.add(u.getProduct());
		}
		
		List<ProductWrapper> productWrappers = new ArrayList<ProductWrapper>();
		products.forEach(p -> productWrappers.add(new ProductWrapper(p)));
		
		return new Gson().toJson(productWrappers);
	}
	
	@PostMapping(value = "/addProductToUser")
	@CrossOrigin
	public String addProductToUser(@RequestBody String model)
	{
		String strId = model.replace("=", "").trim();
		Long id = Long.valueOf(strId);
		
		if(productRepository.findById(id) == null)
			return "Brak kursu w bazie danych.";
		
		if(AuthorizationImitation.getUser() == null)
			return "Musisz się zalogować aby kupić kurs";
		
		UserProductMap upm = new UserProductMap();
		upm.setUser(AuthorizationImitation.getUser());
		upm.setProduct(productRepository.findById(id));
		
		userProductMap.save(upm);
		
		return "Dobry zakup!";
	}
	
	@PostMapping(value = "/addProduct")
	@CrossOrigin
	public ResponseEntity<?> addProduct(@ModelAttribute Product product) {
		try
		{
			if(product == null)
				return ResponseEntity.status(500).build();
			
			product.setId(null);
			productRepository.save(product);
			
			return ResponseEntity.ok("Kurs " + product.getTitle() + " dodano pomyślnie");
		}catch(Exception e)
		{
			return ResponseEntity.status(500).build();
		}
	}
	
	@PostMapping("/deleteProduct")
	@CrossOrigin
    public String deleteProduct(@RequestBody String model) {
		try
		{
			String strId = model.replace("=", "").trim();
			Long id = Long.valueOf(strId);

			if(productRepository.findById(id) == null)
				return "Brak kursu w bazie danych.";
		
			
			productRepository.delete(productRepository.findById(id));

			return "Kurs usunięto pomyślnie";  
		}catch(Exception e)
		{
			return e.getMessage();
		}
     }

	private void fillProductTable()
	{
		Product product = new Product();
		product.setTitle("Kurs HTML");
		product.setDescription("Tworzenie stron www rozpoczniemy od pierwszego projektu, zdobędziemy też cenną wiedzę podstawową. Z przeglądu technologii webowych wiemy, iż HTML to język opisowy oparty na tzw. znacznikach, służący do opisu zawartości strony www.");
		product.setMoney(BigDecimal.valueOf(10.99));
		product.setVideo("https://www.youtube.com/watch?v=k2IydkL3EOs");
		productRepository.save(product);
		ProductWrapper wp = new ProductWrapper();
		wp.setProduct(product);
		
		Product product2 = new Product();
		product2.setTitle("Kurs MySQL");
		product2.setDescription("Przed Państwem pierwszy odcinek kursu SQL, czyli języka zapytań kierowanych bezpośrednio do bazy danych. W odcinku tym poznamy najważniejsze definicje, czyli tak naprawdę niezbędną terminologię, słownictwo jakie należy znać w pracy z bazami danych.");
		product2.setMoney(BigDecimal.valueOf(12.99));
		product2.setVideo("https://www.youtube.com/watch?v=99JAI24Zd24&t=1726s");
		ProductWrapper wp2 = new ProductWrapper();
		wp2.setProduct(product2);
		productRepository.save(product2);
		
		Product product3 = new Product();
		product3.setTitle("Kurs PHP");
		product3.setDescription("Dzięki nauce PHP zrozumiemy jak w ogóle działają witryny www, jak dbać o ich bezpieczeństwo, oraz przekonamy się ile pracy kosztuje ich wykonanie. W kursie tym pojawi się cała masa praktycznych przykładów.");
		product3.setMoney(BigDecimal.valueOf(12.99));
		product3.setVideo("https://www.youtube.com/watch?v=tD0Q5QwoQJI&t=1393s");
		ProductWrapper wp3 = new ProductWrapper();
		wp3.setProduct(product3);
		productRepository.save(product3);
	}
}
