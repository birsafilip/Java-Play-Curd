package controllers;

import play.*;
import play.mvc.*;
import models.Product;
import java.util.List;
import java.util.ArrayList;

import views.html.products.list;
public class Products extends Controller{

	public static Result list(){
		List<Product>products=Product.findAll();
		return ok(list.render(products));
	}
	public static Result newProduct(){
		return TODO;
		
	}
	
	public static Result details(String ean){
		return TODO;
		
	}
	
	public static Result save(){
		return TODO;
		
	}
	
}
