package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.IProductsDao;
import dao.ProductsDao;
import hbm.Products;

@ManagedBean(name = "product")
@RequestScoped
public class ProductsMB {

	private Products product;

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public ProductsMB() { // Creamos constructor donde inicializamos el objeto
		product = new Products();
	}

	// Metodos //

	public String insertar() {

		IProductsDao productDao = new ProductsDao();
		System.out.println("llego");
		productDao.insertar(product);

		return null;

	}
	
	/*public String borrar() {
		IProductsDao productDao = new ProductsDao();
		productDao.borrar(product.getIdItem());
		return null;
	}
	+
}*/




}