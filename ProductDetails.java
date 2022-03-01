package services;

import java.util.ArrayList;
import dao.ProductDao;
import model.ProductModel;

public class ProductDetails implements Parent{
	
	ProductDao prodDao = new ProductDao();
	
	
	ArrayList<ProductModel> prodList = new ArrayList<ProductModel>();
	
	
	public void addProductToList(ProductModel em) throws ClassNotFoundException {
		
		
		prodList.add(em);
		prodDao.storeprodRecordInDb(prodList);
	}

}
