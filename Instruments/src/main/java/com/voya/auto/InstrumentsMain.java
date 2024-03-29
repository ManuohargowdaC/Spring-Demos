package com.voya.auto;

public class InstrumentsMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.voya.auto");
		Perpormer performer = context.getBean("performer",performer.class);
		performer.playMusic("v", "sing");
	performer.playMusic("k", "a");
	performer.playMusic("g", "song");
	}

}
