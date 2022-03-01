package controller;

import java.util.Scanner;

import dao.ProductDao;
import model.ProductModel;
import services.ProductDetails;

public class MainController {

	public static void main(String[] args) throws ClassNotFoundException {
		
	ProductDetails ed = new ProductDetails();
	ProductDao prodDao = new ProductDao();
	System.out.println("---------------------------------------------------------");
	System.out.println("------------ INVENTORY MANAGEMENT SYSTEM ----------------");
	System.out.println("---------------------------------------------------------\n");
		
	System.out.println("PLEASE SELECT THE LOGIN TYPE \n");
	boolean temp = true;
	while(temp) {

		System.out.println("---------------------------------------------------------\n");
	System.out.println(" >> ADMINISTRATOR \n >> CUSTOMER \n >> EXIT");

	System.out.println("---------------------------------------------------------\n");
	Scanner sc = new Scanner(System.in);
	int option = Integer.parseInt(sc.nextLine());
	
	switch(option) {
		case 1: {
			System.out.println(" ENTER THE USERNAME : ");
			String adminName = sc.nextLine();
			System.out.println(" ENTER THE PASSWORD : ");
			String adminPwd = sc.nextLine();
			
			if(adminName.equals("arun") && adminPwd.equals("123")) {
					boolean temp1 = true;
					while(temp1) {

						System.out.println("---------------------------------------------------------\n");
					System.out.println(" \n WELCOME "+adminName+" .!! "+" SELECT WHAT YOU NEED TO DO \n");
					System.out.println(" >> INSERT A PRODUCT \n >> VIEW ENTIRE PRODUCTS \n >> DELETE A PRODUCT \n >> EXIT \n");

					System.out.println("---------------------------------------------------------\n");
					boolean flag1 = true;
					int adminOption = 0;
					while(flag1) {
							try {
								adminOption = Integer.parseInt(sc.nextLine());
								flag1 = false;
								}
							catch(Exception e) {
								System.out.println("INVALID INPUT .!");
								flag1 =true;
								}
								}
							
						switch(adminOption) {
							case 1:{
								System.out.println("---------------------------------------------------------");
								System.out.println("ENTER THE COUNT OF THE PRODUCTS THAT YOU NEED TO ADD : ");
								System.out.println("---------------------------------------------------------");
									
								int prodCount = Integer.parseInt(sc.nextLine());
								int id;
								String name;
								String code;
								int price;
								int quantity;
								
								for(int i=0; i<prodCount; i++) {
									System.out.println("ID : ");
									id = Integer.parseInt(sc.nextLine());
									System.out.println(" NAME : ");
									name = sc.nextLine();
									System.out.println(" CODE : ");
									code = sc.nextLine();
									System.out.println(" PRICE : ");
									price = Integer.parseInt(sc.nextLine());
									
									System.out.println(" QUANTITY : ");
									quantity = Integer.parseInt(sc.nextLine());
									ProductModel pm = new ProductModel(id,name,code,price,quantity);
									ed.addProductToList(pm);
									}
									
								break;
								}
								
								case 2:{
									
									prodDao.viewProductTableRecord();
									break;
								}
								
								case 4:{
								
									System.out.println("Enter Product Id");
									int id = Integer.parseInt(sc.nextLine());
									System.out.println(" \n SELECT THE FIELD WHERE YOU NEED TO UPDATE. \n 1) NAME \n 2) PRICE \n 3) QUANTITY \n ");
									int updateOption = Integer.parseInt(sc.nextLine());
									switch(updateOption) {
									
									case 1:{
										
										System.out.println(" ENTER THE NEW PRODUCT's NAME WHOSE ID IS "+id);
										String newName = sc.nextLine();
										prodDao.updateProductRecord(updateOption,id,newName);
										break;
									}
									
									case 2:{
										
										
										System.out.println(" ENTER THE NEW PRODUCT's PRICE WHOSE ID IS "+id);
										String newPrice = sc.nextLine();
										prodDao.updateProductRecord(updateOption,id,newPrice);
										break;
									}
									
									case 3:{
										
										
										System.out.println(" ENTER THE NEW PRODUCT's QUANTITY WHOSE ID IS "+id);
										int newQuantity = Integer.parseInt(sc.nextLine());
										prodDao.updateProductRecord(id,newQuantity);
										break;
									}
									
								
									}
									break;
								}
								
								case 3:{
									
									System.out.println("---------------------------------------------------------");
									System.out.println("ENTER THE PRODUCT's ID THAT YOU NEED TO DELETE : ");
									System.out.println("---------------------------------------------------------");
									prodDao.viewProductTableRecord();
									int id = Integer.parseInt(sc.nextLine());
									prodDao.DeleteProductTableRecord(id);
									break;
								}
								
								case 5:{
									
									temp1 = false;
									break;
								}
							}
						}
						
					}
			
					else {
						
						System.out.println("---------------------------------------------------------");
						System.out.println("INVALID CREDENTIALS .!!");
						System.out.println("---------------------------------------------------------");
					}
					break;
				}
		
				case 2:{
					
					System.out.println("---------------------------------------------------------");
					System.out.println("1) VIEW PRODUCTS AND ITS DETAILS \n 2) Exit");
					System.out.println("---------------------------------------------------------");
					boolean flag1 = true;
					int userOption = 0;
					while(flag1) {
						try {
							userOption = Integer.parseInt(sc.nextLine());
							flag1 = false;
						}catch(Exception e) {
							System.out.println("INVALID OPTION .! PLEASE ENTER VALID OPTION NUMBER ");
							flag1 =true;
						}
					}
					
					switch(userOption) {
					
					case 1:{
						
						prodDao.viewProductTableRecord();
						break;
					}
					
					case 2:{
						
						flag1=false;
					}
					}
					}
				
					case 3:{
						
						temp = false;
					}
					}
				}
			}
		}
