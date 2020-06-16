import java.awt.Color;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class JNativeHookInput implements NativeKeyListener{

	public void nativeKeyPressed(NativeKeyEvent e) {
		System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
		String keypressed = NativeKeyEvent.getKeyText(e.getKeyCode());
		
		Main.tempLabel.setText("Keypressed: " + keypressed);
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("W")) {
        	Main.w_view.setBackground(Color.black);
        	Main.w_view.setForeground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("A")) {
        	Main.a_view.setBackground(Color.black);
        	Main.a_view.setForeground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("S")) {
        	Main.s_view.setBackground(Color.black);
        	Main.s_view.setForeground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("D")) {
        	Main.d_view.setBackground(Color.black);
        	Main.d_view.setForeground(Color.white);
        }
        
        // Arrow Keys
 		if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Up")) {
         	Main.up_view.setBackground(Color.black);
         	Main.up_view.setForeground(Color.white);
        }
         
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Left")) {
         	Main.left_view.setBackground(Color.black);
         	Main.left_view.setForeground(Color.white);
        }
         
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Down")) {
         	Main.down_view.setBackground(Color.black);
         	Main.down_view.setForeground(Color.white);
        }
         
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Right")) {
         	Main.right_view.setBackground(Color.black);
         	Main.right_view.setForeground(Color.white);
        }
        
        // Special Keys
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Left Shift")) {
        	Main.shift_view.setBackground(Color.black);
        	Main.shift_view.setForeground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Ctrl")) {
        	Main.ctrl_view.setBackground(Color.black);
        	Main.ctrl_view.setForeground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Space")) {
        	Main.space_view.setBackground(Color.black);
        	Main.space_view.setForeground(Color.white);
        }
        
		
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
		
		// WASD
		if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("W")) {
        	Main.w_view.setForeground(Color.black);
        	Main.w_view.setBackground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("A")) {
        	Main.a_view.setForeground(Color.black);
        	Main.a_view.setBackground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("S")) {
        	Main.s_view.setForeground(Color.black);
        	Main.s_view.setBackground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("D")) {
        	Main.d_view.setForeground(Color.black);
        	Main.d_view.setBackground(Color.white);
        }
        
        // Arrow Keys
		if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Up")) {
        	Main.up_view.setForeground(Color.black);
        	Main.up_view.setBackground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Left")) {
        	Main.left_view.setForeground(Color.black);
        	Main.left_view.setBackground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Down")) {
        	Main.down_view.setForeground(Color.black);
        	Main.down_view.setBackground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Right")) {
        	Main.right_view.setForeground(Color.black);
        	Main.right_view.setBackground(Color.white);
        }
        
        // Special Keys
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Left Shift")) {
        	Main.shift_view.setForeground(Color.black);
        	Main.shift_view.setBackground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Ctrl")) {
        	Main.ctrl_view.setForeground(Color.black);
        	Main.ctrl_view.setBackground(Color.white);
        }
        
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Space")) {
        	Main.space_view.setForeground(Color.black);
        	Main.space_view.setBackground(Color.white);
        }
	}

	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
