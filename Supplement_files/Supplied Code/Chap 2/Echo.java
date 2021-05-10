import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class Echo extends JFrame 
                            implements ActionListener
{
   private JTextField hostInput,lineToSend;
   private JLabel hostPrompt,messagePrompt;
   private JTextArea received;
   private JButton closeConnection;
   private JPanel hostPanel,entryPanel;
   private final int ECHO = 7;
   private static Socket socket = null;
   private Scanner input;
   private PrintWriter output;

   public static void main(String[] args)
   {
      Echo frame = new Echo();
      frame.setSize(600,400);
      frame.setVisible(true);

      frame.addWindowListener(
         new WindowAdapter()
         {
            public void windowClosing(WindowEvent e)
            {
               if (socket != null)
               {
                  try
                  {
                     socket.close();
                  }
                  catch (IOException ioEx)
                  {
                     System.out.println(
                       "\n* Unable to close link! *\n");
                     System.exit(1);
                  }
                  System.exit(0);
               }
            }
         }
      );
   }

   public Echo()
   {
      hostPanel = new JPanel();

      hostPrompt = new JLabel("Enter host name:");
      hostInput = new JTextField(20);
      hostInput.addActionListener(this);
      hostPanel.add(hostPrompt);
      hostPanel.add(hostInput);
      add(hostPanel, BorderLayout.NORTH);

      entryPanel = new JPanel();

      messagePrompt = new JLabel("Enter text:");
      lineToSend = new JTextField(15);
      
      //Change field to editable when
      // host name entered...
      lineToSend.setEditable(false);
 
      lineToSend.addActionListener(this);

      /************************************************
      * ADD COMPONENTS TO PANEL AND APPLICATION FRAME *
      ************************************************/

      /********************************************
      * NOW SET UP TEXT AREA AND THE CLOSE BUTTON *
      ********************************************/
   }

   public void actionPerformed(ActionEvent event)
   {
      if (event.getSource() == closeConnection)
      {
         if (socket != null)
         {
            try
            {
               socket.close();
            }
            catch(IOException ioEx)
            {
               System.out.println(
                     "\n* Unable to close link!*\n");
               System.exit(1);
            }
            lineToSend.setEditable(false);
            hostInput.grabFocus();
         }
         return;
      }

      if (event.getSource() == lineToSend)
      {

         /******************/
         * SUPPLY CODE HERE *
         *******************/

      }

      //Must have been entry into host field...
      String host = hostInput.getText();
      try
      {

         /*******************
         * SUPPLY CODE HERE *
         *******************/

      }
      catch (UnknownHostException uhEx)
      {
         received.append("\n*** No such host! ***\n");
         hostInput.setText("");
      }
      catch (IOException ioEx)
      {
         received.append("\n*** " + ioEx.toString() 
                                          	+ " ***\n");
      }
   }
}
