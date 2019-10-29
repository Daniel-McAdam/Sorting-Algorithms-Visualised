/**
 * Sorting Algorithm Visualisation Project
 * @author Daniel McAdam
 * @version 1.0
 */

package sortAlgoVisualised;
import javax.swing.JFrame;

public class Program {

	public static void main(String[] args) {

		JFrame frame = new JFrame ("Sorting Algorithms Visualised");	
		
		frame.add(new Visual());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1200,800);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		frame.setResizable(true);
		

	}
	
}

