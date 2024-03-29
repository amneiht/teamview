package events;

import java.awt.AWTException;
import java.awt.Robot;
// this is a test for robot , i copy it in the intenet
/**
 * A Java Robot example class.
 * 
 * Caution: Using the Java Robot class improperly can cause a lot of system
 * problems. I had to reboot my Mac ~10 times yesterday while trying to debug
 * this code.
 * 
 * I created this class to demonstrate the Java Robot class on a Mac OS X
 * system, though it should run on Linux or Windows as well.
 * 
 * On a Mac system, I place the TextEdit text editor in the upper-left corner of
 * the screen, and put a bunch of blank lines in the editor. Then I run this
 * Java Robot example from Eclipse or the Unix command line.
 * 
 * It types the three strings shown in the code below into the text editor.
 *
 * Many thanks to the people on the Mac Java-dev mailing list for your help.
 * 
 * @author Alvin Alexander, http://devdaily.com
 *
 */
/**
 * A Java Robot example class.
 * 
 * Caution: Using the Java Robot class improperly can cause a lot of system
 * problems. I had to reboot my Mac ~10 times yesterday while trying to debug
 * this code.
 * 
 * I created this class to demonstrate the Java Robot class on a Mac OS X
 * system, though it should run on Linux or Windows as well.
 * 
 * On a Mac system, I place the TextEdit text editor in the upper-left corner of
 * the screen, and put a bunch of blank lines in the editor. Then I run this
 * Java Robot example from Eclipse or the Unix command line.
 * 
 * It types the three strings shown in the code below into the text editor.
 *
 * Many thanks to the people on the Mac Java-dev mailing list for your help.
 * 
 * @author Alvin Alexander, http://devdaily.com
 *
 */
public class JavaRobotExample {
	Robot robot = new Robot();

	public static void main(String[] args) throws AWTException {
		new JavaRobotExample();
	}

	public JavaRobotExample() throws AWTException {
		robot.setAutoDelay(40);
		robot.delay(1000);
//		robot.mouseMove(1500, 500);
//		robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
//		robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
		robot.mouseWheel(4);
		robot.delay(1000);
		System.exit(0);
	}


	@SuppressWarnings("unused")
	private void type(int i) {
		robot.delay(40);
		robot.keyPress(i);
		// robot.keyRelease(i);
	}

	@SuppressWarnings("unused")
	private void type(String s) {
		byte[] bytes = s.getBytes();
		for (byte b : bytes) {
			int code = b;
			// keycode only handles [A-Z] (which is ASCII decimal [65-90])
			if (code > 96 && code < 123)
				code = code - 32;
			robot.delay(10);
			robot.keyPress(code);
			robot.keyRelease(code);
		}
	}
}
