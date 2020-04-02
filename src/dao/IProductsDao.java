package dao;

import java.util.List;

import hbm.Products;

public interface IProductsDao {

	public void insertar(Products product);

	public List<Products> leer(Products product);

	public static Products select(int IdItem) {
		return null;
	}

	public int borrar(Products product);

	

}
