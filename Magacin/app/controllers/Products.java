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
	
		
	
	public static Result index(){
		return redirect(routes.Products.list());
		
		
	}
	
	public static Result list(){
		List<Product>products=Product.findAll();
		return ok(list.render(products));
	}
	public static Result newProduct(){
		return ok(details.render(productForm));
		
	}
	
	public static Result details(String ean){
		final Product product=Product.findByEan(ean);
		if(product==null){
			return notFound(String.format("Product %s does not exist", ean));
			
		}
		Form<Product>filledForm=productForm.fill(product);
		return ok(details.render(filledForm));
		
	}
	
	public static Result save(){
		Form<Product>boundForm=productForm.bindFromRequest(); /*bining from form*/
		Product product=boundForm.get();
		if(boundForm.hasErrors()){
			flash("error","pleace correct the form below");
			return badRequest(details.render(boundForm));
			
		}
		product.save();
		flash("success",String.format("Successfully added product %s", product));
		return redirect(routes.Products.list());
		
	}
	
}
