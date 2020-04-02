package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.IProductsDao;
import dao.ProductsDao;

import hbm.Products;

@ManagedBean(name = "inicio")
@SessionScoped
public class InicioMB {

	private Products product;

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public InicioMB() {

		product = new Products();
	}

	public List<Products> getProductsList() {
		IProductsDao productDao = new ProductsDao();
		return productDao.leer(product);
	}

	public String select() {
		IProductsDao productDao = new ProductsDao();
		this.product = ProductsDao.select(product.getIdItem());
		try {
			if (product.getNombre() != null) {
				return "item";
			}
		} catch (NullPointerException e) {
			return "error";
		}
		return "error";
	}
	public int borrar() {
		IProductsDao productDao = new ProductsDao();
		productDao.borrar(product);
		return 0;

}


}
