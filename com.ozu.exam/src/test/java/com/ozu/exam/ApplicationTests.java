package com.ozu.exam;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.ozu.exam.beans.FirstMessageBean;
import com.ozu.exam.beans.MessageBean;
import com.ozu.exam.beans.SecondMessageBean;
//import com.ozu.exam.beans.MyBean;
import com.ozu.exam.model.Book;
import com.ozu.exam.repository.BookRepository;

@SpringBootTest
class ApplicationTests {
	@Autowired
	MessageBean firstBean;
	
	@Autowired
	MessageBean secondBean;
	
	@Autowired
	BookRepository repo;

//	@Autowired
//	MyBean myBean;

//	@Autowired
//	PurchaseOrderRepository orderRepo;
	
	
	
	@Test
	void test() {
		
		System.out.println(firstBean.getMessage());
		
		firstBean.setMessage("Good evening");
		System.out.println(firstBean.getMessage());
		
		
		System.out.println(secondBean.getMessage());
		System.out.println(firstBean.getMessage());

	}

	@Test
	void testBookRepo() {
		Book book1 = new Book("6054898019", "Eclipse ile Java", "Esma Meral", "Dikey Eksen");
		Book book4 = new Book("6054898022", "Spring Framework", "Esma Meral", "Dikey Eksen");
		Book book2 = new Book("1234567981", "Introduction to Java Programming", "Daniel Liang", "Pearson");
		Book book3 = new Book("12", "Introduction to Java Programming", "", "");
		repo.save(book1);
		repo.save(book2);
		repo.save(book3);
		repo.save(book4);
		List<Book> books = repo.findByTitleOrAuthor("Eclipse ile Java", "Daniel Liang");
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	@Commit
	void testOrderRepo() {
//		Item item1=new Item();
//		item1.setName("Lenovo Notebook");
//		item1.setPrice(18000);
//		
//		Item item2=new Item();
//		item2.setName("Canon Printer");
//		item2.setPrice(2000);
//		
//		Owner owner1=new Owner();
//		owner1.setName("Kadir Deniz");
//		owner1.setAddress("Uskudar");
//		
//		Owner owner2=new Owner();
//		owner2.setName("Canan Kara");
//		owner2.setAddress("Merter");
//		
//		PurchaseOrder order = new PurchaseOrder();
//		order.getItems().add(item1);
//		order.getItems().add(item2);
//		order.setOwner(owner1);
//		
//		
//		owner1.getOrders().add(order);
//		item1.setOrder(order);
//		item2.setOrder(order);
//		
//		orderRepo.save(order);

	}

}
