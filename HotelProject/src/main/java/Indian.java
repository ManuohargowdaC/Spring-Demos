package main.java;

import java.util.Arrays;
import java.util.List;

public class Indian implements IFoodMenu {

	@Override
	public List<String> showItems() {
		// TODO Auto-generated method stub
		List<String> Indian = Arrays.asList("chicken","Biryani");
		return Indian;
		
	}
	

}
