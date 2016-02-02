package org.sintef.jarduino.myProjects;

import java.util.Scanner;
import org.sintef.jarduino.DigitalPin;
import org.sintef.jarduino.DigitalState;
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.PinMode;
import org.sintef.jarduino.comm.Serial4JArduino;

public class Menu extends JArduino{
	private static int[] binNum = new int[8];
	
	
	public Menu(String port) {
        super(port);
    }
	
	@Override
    protected void setup() {
        // initialize the digital pin as an output.
        // Pin 13 has an LED connected on most Arduino boards:
        pinMode(DigitalPin.PIN_12, PinMode.OUTPUT);
        pinMode(DigitalPin.PIN_11, PinMode.OUTPUT);
        pinMode(DigitalPin.PIN_10, PinMode.OUTPUT);
        pinMode(DigitalPin.PIN_9, PinMode.OUTPUT);
        pinMode(DigitalPin.PIN_8, PinMode.OUTPUT);
        pinMode(DigitalPin.PIN_7, PinMode.OUTPUT);
        pinMode(DigitalPin.PIN_6, PinMode.OUTPUT);
        pinMode(DigitalPin.PIN_5, PinMode.OUTPUT);
    }
	
	@Override
	protected void loop() {
        // set the LED on
		if(binNum[0] == 0){ digitalWrite(DigitalPin.PIN_12, DigitalState.LOW); } else{ digitalWrite(DigitalPin.PIN_12, DigitalState.HIGH);}
		if(binNum[1] == 0){ digitalWrite(DigitalPin.PIN_11, DigitalState.LOW); } else{ digitalWrite(DigitalPin.PIN_11, DigitalState.HIGH);}
		if(binNum[2] == 0){ digitalWrite(DigitalPin.PIN_10, DigitalState.LOW); } else{ digitalWrite(DigitalPin.PIN_10, DigitalState.HIGH);}
		if(binNum[3] == 0){ digitalWrite(DigitalPin.PIN_9, DigitalState.LOW); } else{ digitalWrite(DigitalPin.PIN_9, DigitalState.HIGH);}
		if(binNum[4] == 0){ digitalWrite(DigitalPin.PIN_8, DigitalState.LOW); } else{ digitalWrite(DigitalPin.PIN_8, DigitalState.HIGH);}
		if(binNum[5] == 0){ digitalWrite(DigitalPin.PIN_7, DigitalState.LOW); } else{ digitalWrite(DigitalPin.PIN_7, DigitalState.HIGH);}
		if(binNum[6] == 0){ digitalWrite(DigitalPin.PIN_6, DigitalState.LOW); } else{ digitalWrite(DigitalPin.PIN_6, DigitalState.HIGH);}
		if(binNum[7] == 0){ digitalWrite(DigitalPin.PIN_5, DigitalState.LOW); } else{ digitalWrite(DigitalPin.PIN_5, DigitalState.HIGH);}
		
        delay(1000); // wait for a second
    }
	
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		int c = 7;
		String serialPort = "COM3";
		Conversion num = new Conversion();
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type a number you want to convert: ");
		int x = keyboard.nextInt();
		num.setDecNum(x);
		binNum = num.getBinNum();
		
		//Prints the bin array inverted, so the number typed is right.
		//while(c >= 0){ System.out.print(binNum[c]); c--; }
		
		//Selects the port where the Arduino is connected.
		JArduino arduino = new Menu(serialPort);
		arduino.runArduinoProcess();
		
		while (x <= 255 && x >= 0){
			System.out.println("Type a number you want to convert: ");
			int x1 = keyboard.nextInt();
			num.setDecNum(x1);
			binNum = num.getBinNum();
		}
		
		arduino.stopArduinoProcess();
		
	}
	
}