package main.java;
@Autowired
public class Customer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext context = new AnnotationConfigApplicationContext("com.voya.food");
		Waiter waiter = context.getBean("waiter",Waiter.class);
		
		waiter.viewMenuCard("italian");
		waiter.viewMenuCard("indian");
		waiter.viewMenuCard("chinese");

	}

}