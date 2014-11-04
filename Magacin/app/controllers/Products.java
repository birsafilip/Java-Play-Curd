package controllers;

import play.*;
import play.mvc.*;
import models.Product;
import java.util.List;
import java.util.ArrayList;
import play.data.Form;
import views.html.products.*;
public class Products extends Controller{

	public static final Form<Product>productForm=Form.form(Product.class);
	
	public static Result list(){
		List<Product>products=Product.findAll();
		return ok(list.render(products));
	}
	public static Result newProduct(){
		return ok(details.render(productForm));
		
	}
	
	public static Result details(String ean){
		return TODO;
		
	}
	
	public static Result save(){
		Form<Product>boundForm=productForm.bindFromRequest(); /*bining from form*/
		Product product=boundForm.get();
		product.save();
		return ok(String.format("Saved product %s", product));
		
	}
	
}
