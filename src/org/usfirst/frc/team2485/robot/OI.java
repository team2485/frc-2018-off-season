package org.usfirst.frc.team2485.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick XBOX;
	
	public static final int XBOX_A_PORT = 1;
	public static final int XBOX_B_PORT = 2;
	public static final int XBOX_X_PORT = 3;
	public static final int XBOX_Y_PORT = 4;
	public static final int XBOX_LBUMPER_PORT = 5;
	public static final int XBOX_RBUMPER_PORT = 6;  
	public static final int XBOX_START_PORT = 9;  
	public static final int XBOX_BACK_PORT = 10;  
	public static final int XBOX_XBOX_PORT = 11;  
	public static final int XBOX_UP_PORT = 12;  
	public static final int XBOX_DOWN_PORT = 13;  
	public static final int XBOX_LEFT_PORT = 14;
	public static final int XBOX_RIGHT_PORT = 15;
	
	public static final int XBOX_LXJOSYSTICK_PORT = 0;
	public static final int XBOX_LYJOYSTICK_PORT = 1;
	public static final int XBOX_LTRIGGER_PORT = 2;
	public static final int XBOX_RTRIGGER_PORT = 3;
	public static final int XBOX_RXJOYSTICK_PORT = 4;
	public static final int XBOX_RYJOYSTICK_PORT = 5;
	
	public static JoystickButton XBOX_UP;
	public static JoystickButton XBOX_DOWN;
	public static JoystickButton XBOX_LEFT;
	public static JoystickButton XBOX_RIGHT;
	public static JoystickButton XBOX_A;
	public static JoystickButton XBOX_B;
	public static JoystickButton XBOX_X;
	public static JoystickButton XBOX_Y;
	public static JoystickButton XBOX_LBUMPER;
	public static JoystickButton XBOX_RBUMPER;
	public static JoystickButton XBOX_XBOX;
	
	public static void init() {
		
		XBOX = new Joystick(0);
		
		XBOX_UP = new JoystickButton(XBOX, XBOX_UP_PORT);
		XBOX_DOWN = new JoystickButton(XBOX, XBOX_DOWN_PORT);
		XBOX_LEFT = new JoystickButton(XBOX, XBOX_LEFT_PORT);
		XBOX_RIGHT = new JoystickButton(XBOX, XBOX_RIGHT_PORT);
		
		XBOX_A = new JoystickButton(XBOX, XBOX_A_PORT);
		XBOX_B = new JoystickButton(XBOX, XBOX_B_PORT);
		XBOX_X = new JoystickButton(XBOX, XBOX_X_PORT);
		XBOX_Y = new JoystickButton(XBOX, XBOX_Y_PORT);
		
		XBOX_LBUMPER = new JoystickButton(XBOX, XBOX_LBUMPER_PORT);
		XBOX_RBUMPER = new JoystickButton(XBOX, XBOX_RBUMPER_PORT);
		
		XBOX_XBOX = new JoystickButton(XBOX, XBOX_XBOX_PORT);
		
	}
	
}
