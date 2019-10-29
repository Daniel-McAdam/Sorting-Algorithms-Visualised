package sortAlgoVisualised;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Visual extends JPanel implements ActionListener{
	
	Timer visualUpdateTimer = new Timer(1000,this); // timer expire is event i think
	SortingAlgorithm sort = new SortingAlgorithm();

	

	int delimiter = 1;
	
	JButton update;
	
	JSlider delay;
	JSlider size;
	
	JLabel lblDelay;
	JLabel lblSize;
	JLabel lblDelayCount;
	JLabel lblSizeCount;
	
	JComboBox Choice;
	int choicenum = 0; //fix
	
	String[] sorts = {"Bubble Sort", "Incertion Sort"};
	
	Color current = Color.blue;
	Color bar = Color.pink;
	Color background = Color.yellow;

	boolean lock = false;

	event e = new event();
	

	int currentPosition = 1;
	int curpos2 = 1;
	


	
	public Visual() //components need to go in constructor to avoid being redrawn
	{
		
		
		update = new JButton("Update Size (Restart)");
		delay = new JSlider(JSlider.HORIZONTAL,0,100,50);
		size = new JSlider(JSlider.HORIZONTAL,0,300,100);
		
		System.out.println("size value: " + (size.getValue()));
		sort.initialiseArray((size.getValue()));
		
		
		
	//	Choice = new JComboBox(sorts); // To Do
		
		delay.setBackground(background);
		size.setBackground(background);
		
		update.addActionListener(this);
		delay.addChangeListener(e);
		size.addChangeListener(e);
		
		lblDelay = new JLabel("Delay");
		lblSize = new JLabel("Size");
		lblDelayCount = new JLabel(Integer.toString(delay.getValue()));
		lblSizeCount = new JLabel(Integer.toString(size.getValue()));
		
		add(lblDelay);
		add(delay);
		add(lblDelayCount);
		add(lblSize);
		add(size);
		add(lblSizeCount);
		
//		add(Choice); // To Do
		add(update);
		

		visualUpdateTimer.setDelay(delay.getValue());

		visualUpdateTimer.start();
	}
	
	
	public void paintComponent(Graphics visualSort) {
		super.paintComponent(visualSort);
		
		this.setBackground(background);
		
		int width = 5;
		int height = 9;
		
		int x = this.getWidth() - sort.sortArray.length * (width + 2); // To Do
		int y = this.getHeight();
		
		
		
		for(int i44 = 1; i44 < sort.sortArray.length; i44++)
		{
			
			if(i44 == currentPosition)
			{
				visualSort.setColor(current);
			}
		
			else {
				visualSort.setColor(bar);
			}
			
			visualSort.fillRect(x , y, -width, -sort.sortArray[i44]*height);
			x += width +2 ;

		}		
		
	}


	
	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource() == visualUpdateTimer)
			
		{

			bubble();
			
		//	insert();
			

		repaint();
	}
	
	if(e.getSource() == update)
	{
		currentPosition=0;
		delimiter =1;
		sort.initialiseArray(Integer.valueOf(lblSizeCount.getText()));

		
		repaint();
	
	}
	}
	
	public void insert()
	{
		if(currentPosition >= sort.sortArray.length)
		{
			// To Do
		}
		else
		{
		if(curpos2 < sort.sortArray.length)
		{

		
			currentPosition = curpos2;
			
			if(currentPosition > 0 && sort.sortArray[currentPosition - 1] > sort.sortArray[currentPosition])
			{
				curpos2 = 0;
				System.out.println("test");
				sort.intsort2(currentPosition);
				currentPosition--;
				System.out.println(currentPosition + " curpos");
			
			}
			
		curpos2++;
			}
		else {
			curpos2 = 0;
		}
		}
		
	}


	public void bubble()
	{
		
		if(currentPosition >= sort.sortArray.length - delimiter)
		{
			currentPosition = 0;
			delimiter++;
		}
		else {
			
		sort.bubbleSort(currentPosition);
		currentPosition++;
		}
	}
	
	public class event implements ChangeListener {
	
//Events handled slightly diffferently for JSlider
		@Override
		public void stateChanged(ChangeEvent e) {
			if( e.getSource() == delay)
			{
			
			lblDelayCount.setText(Integer.toString(delay.getValue()));
		visualUpdateTimer.setDelay(delay.getValue());	
		}
			if (e.getSource() == size)
			{
				lblSizeCount.setText(Integer.toString(size.getValue()));
			}
			
		}
	}


}
