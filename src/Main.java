import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Main {

	// Main Window
	private static JFrame mainFrame;
	private static JPanel mainPanel;
	public static JLabel tempLabel;
	
	// View Window
	private static JFrame viewFrame;
	private static JPanel viewPanel;
	
	// Button Initialisation
	public static JButton w_view;
	public static JButton a_view;
	public static JButton s_view;
	public static JButton d_view;
	
	public static JButton up_view;
	public static JButton left_view;
	public static JButton down_view;
	public static JButton right_view;
	
	public static JButton shift_view;
	public static JButton ctrl_view;
	public static JButton space_view;
	
	
	public static void main(String[] args) {
		// https://www.youtube.com/watch?v=5o3fMLPY7qY for ref
		CreateMainWindow();
		CreateViewWindow();
		Input();
		
	}

	private static void CreateViewWindow() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		Color bgColor = new Color(0, 0, 0, 150);
		
		viewFrame = new JFrame();
		viewPanel = new JPanel();
		
		// WASD
		w_view = CreateViewButton("W");
		viewPanel.add(w_view);
		
		s_view = CreateViewButton("S");
		viewPanel.add(s_view);
		
		a_view = CreateViewButton("A");
		viewPanel.add(a_view);
				
		d_view = CreateViewButton("D");
		viewPanel.add(d_view);
		
		// Arrow Keys
		up_view = CreateViewButton("Up");
		viewPanel.add(up_view);
		
		down_view = CreateViewButton("Down");
		viewPanel.add(down_view);
		
		left_view = CreateViewButton("Left");
		viewPanel.add(left_view);
		
		right_view = CreateViewButton("Right");
		viewPanel.add(right_view);
		
		// Special 
		shift_view = CreateViewButton("Shift");
		viewPanel.add(shift_view);
		
		ctrl_view = CreateViewButton("Ctrl");
		viewPanel.add(ctrl_view);
		
		space_view = CreateViewButton("Space");
		viewPanel.add(space_view);
		
		viewFrame.add(viewPanel);
		
		viewFrame.setUndecorated(true); 		
		viewFrame.setLocation((int)(screenSize.getWidth() - 350), (int)(screenSize.getHeight() - 180));
		viewFrame.setAlwaysOnTop(true);
		viewFrame.setBackground(bgColor);
		
		viewPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));                    
		viewPanel.setLayout(new GridLayout(3,4));
		viewPanel.setBackground(bgColor);
		
		viewFrame.pack();
		viewFrame.setVisible(true);
	}
	
	
	
	private static JButton CreateViewButton(String name) {
		  JButton button = new JButton(name);
		  
		  button.setFocusPainted(false);
		  button.setContentAreaFilled(true);
		  button.setBorderPainted(false);
		  button.setBackground(new Color(255,255,255));
		  
		  return button;
	}
	
	private static void Input() {
		try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {                                                         
            System.err.println("There was a problem registering the native hook.");              
            System.err.println(ex.getMessage());                                                 
            System.exit(1);                                                                      
        }                                                                                        
                                                                                                 
        GlobalScreen.addNativeKeyListener(new JNativeHookInput());                               
	}                                                                                            
                                                                                                 
	public static void CreateMainWindow() {                                                          
		mainFrame = new JFrame("Keyviewer");                                                         
		mainPanel = new JPanel();                                                                    
		                      
		JLabel tempLabel2 = new JLabel("<html>You can go play a game <br/> and the overlay will stay<html>", SwingConstants.CENTER);
		tempLabel2.setPreferredSize(new Dimension(200, 40));
		
		tempLabel = new JLabel("No key pressed", SwingConstants.CENTER);
		tempLabel.setPreferredSize(new Dimension(200, 20));
		
		JButton tempButton = new JButton("Close");
		tempButton.setFocusPainted(false);
		tempButton.setContentAreaFilled(true);
		//tempButton.setBorderPainted(false);
		tempButton.setBackground(new Color(255,255,255));
		tempButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Close();
				
			}
		});
		
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));                    
		mainPanel.setLayout(new GridLayout(0, 1));                                                   
		mainPanel.add(tempLabel2);
		mainPanel.add(tempLabel);
		mainPanel.add(tempButton);                             

		
		mainFrame.add(mainPanel, BorderLayout.CENTER);                                                   
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);                              
		mainFrame.addWindowListener(new WindowAdapter() {                                            
		    public void windowClosing(WindowEvent e) {                                           
		        mainFrame.setExtendedState(JFrame.ICONIFIED);                                        
		                                                                                         
		    }                                                                                    
		});                                                                                      
		mainFrame.pack();                                                                            
		mainFrame.setVisible(true);                                                                  
	}                                                                                            
                                                                                                 
	public static void Close() {
        try {
			GlobalScreen.unregisterNativeHook();
		} catch (NativeHookException e1) {
			e1.printStackTrace();
		}

		mainFrame.dispose();           
		viewFrame.dispose();
	}                                                                                            
                                                                                                 
}