package main.java;

import java.util.Arrays;
import java.util.List;

public class Italian implements IFoodMenu{

	@Override
	public List<String> showItems() {
		// TODO Auto-generated method stub
		List<String> Italian = Arrays.asList("pasta","pizza");
		return Italian;
		
	}

}
