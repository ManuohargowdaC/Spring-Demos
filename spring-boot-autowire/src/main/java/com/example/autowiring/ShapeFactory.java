package com.example.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class ShapeFactory {
	@Autowired
	@Qualifier("rectangle")
	private Shape shape; 
	
	@Autowired
	
	private Shape triangle;
	
	private Shape shaper;
	public ShapeFactory(Shape shaper) {
		super();
		this.shaper=shaper;
	}

	public void printArea(String choice, int  x,int y) {
		if(choice.equals("r"))
			shape.area(x, y);
		if(choice.equals("t"))
			triangle.area(x,y);
		if(choice.equals("s"))
			shaper.area(x,y);
		
	}

	
	
	
	
	
	

}
