package com.voya.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Perpormer  {
	
	@Autowired
	@Qualifier("keyboard")
	private IInstrument instrument;
	
	@Autowired	
	private IInstrument guitar;
	
	@Autowired
	@Qualifier("violin")
	private IInstrument violine;


	public void playMusic(String choice, String song) {
		if (choice.equals("v")) {
			instrument.play(song);
		}
		if (choice.equals("k")) {
			guitar.play(song);
		}
		if (choice.equals("g")) {
			violine.play(song);
        }  
    }

}
