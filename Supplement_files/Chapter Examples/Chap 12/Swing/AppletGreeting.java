import java.awt.*;
import javax.swing.*;

public class AppletGreeting extends JApplet
{
	public void init()
	{
		JLabel message =
				new JLabel("Greetings!",JLabel.CENTER);
		add(message, BorderLayout.CENTER);
	}
}

