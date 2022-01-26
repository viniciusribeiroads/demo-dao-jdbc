package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("=== TEST 2: seller findByDepartmentId ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		list.forEach( e -> System.out.println(e));
		
		System.out.println("=== TEST 3: seller findAll ===");
		List<Seller> listAll = sellerDao.findAll();
		
		listAll.forEach( e -> System.out.println(e));
		
		System.out.println("=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Paul", "paul01@gmail.com", new Date(), 2000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
	}

}
