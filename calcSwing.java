import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class calcSwing extends JFrame implements ActionListener
{
	JTextField textfield;
	JButton[] nb=new JButton[10];		 			//for number buttons
	JButton[] fb=new JButton[9];  					//for function button
	JButton ad,sub,mul,div,clear,delete,equal,dec,neg;
	double num1=0,num2=0,result=0;
	JPanel panel;
	Font mf=new Font("INK FREE",Font.BOLD,30);   			// setting font
	char operator;


	calcSwing()
	{	
									//setting the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setTitle("calculator");
		textfield=new JTextField();
		textfield.setBounds(50,25,300,50);
		setSize(420,550);
		setLayout(null);
		add(textfield);
		setVisible(true);
		textfield.setFont(mf);
		textfield.setEditable(false);
		
									//setting the buttons
				
		ad=new JButton("+");
		sub=new JButton("-");
		mul=new JButton("*");
		div=new JButton("/");
		clear=new JButton("clear");
		delete=new JButton("delete");
		equal=new JButton("=");
		dec=new JButton(".");
		neg=new JButton("(-)");
		
		fb[0]=ad;
		fb[1]=sub;
		fb[2]=mul;
		fb[3]=div;
		fb[4]=clear;
		fb[5]=delete;
		fb[6]=equal;
		fb[7]=dec;
		fb[8]=neg;
		for(int i=0;i<9;i++)				
		  						
			{
				fb[i].addActionListener(this);		  //registering functional  buttons
				fb[i].setFont(mf);
				fb[i].setFocusable(false);
			}			
				for(int i=0;i<10;i++)
				{
					nb[i]=new JButton(String.valueOf(i));	//registering number buttons	
					nb[i].addActionListener(this);
					nb[i].setFont(mf);
					nb[i].setFocusable(false);
				}
                                      
				neg.setBounds(20,430,100,50);
				delete.setBounds(120,430,150,50);
				clear.setBounds(270,430,170,50);


				panel=new JPanel();				//setting the panel
				panel.setBounds(50,100,300,300);
				panel.setLayout(new GridLayout(4,4,10,10));
				panel.add(nb[1]);
				panel.add(nb[2]);
				panel.add(nb[3]);
				panel.add(ad);
				panel.add(nb[4]);
				panel.add(nb[5]);
				panel.add(nb[6]);
				panel.add(sub);
				panel.add(nb[7]);
				panel.add(nb[8]);
				panel.add(nb[9]);
				panel.add(mul);
				panel.add(dec);
				panel.add(nb[0]);
				panel.add(equal);
				panel.add(div);
				add(panel);
				add(neg);
				add(delete);
				add(clear);
				add(textfield);
				setVisible(true);

	}
		public void actionPerformed(ActionEvent e)
		{
			for(int i=0;i<10;i++)
			{
				if(e.getSource()==nb[i])             //number buttons
				{
					textfield.setText(textfield.getText().concat(String.valueOf(i)));
				}
			}
			if(e.getSource()==dec)				//decimal button
			{
				textfield.setText(textfield.getText().concat("."));
			}
			if(e.getSource()==neg)				//negative
			{
				 double temp=Double.parseDouble(textfield.getText());
				temp*=-1;
				textfield.setText(String.valueOf(temp));
			}
			if(e.getSource()==clear)			//clear
			{
				textfield.setText("");
			}
			if(e.getSource()==delete)			//delete
			{
				String str=textfield.getText();
				textfield.setText("");
				for(int i=0;i<str.length()-1;i++)
				{
					textfield.setText(textfield.getText()+str.charAt(i));
				}
			}
			if(e.getSource()==ad)
			{
				num1=Double.parseDouble(textfield.getText());
				operator='+';
				textfield.setText("");				
			}
			if(e.getSource()==sub)
			{
				 num1=Double.parseDouble(textfield.getText());
				operator='-';
				textfield.setText("");				
			}

			if(e.getSource()==mul)
			{
				 num1=Double.parseDouble(textfield.getText());
				operator='*';
				textfield.setText("");				
			}

			if(e.getSource()==div)
			{
				 num1=Double.parseDouble(textfield.getText());
				operator='/';
				textfield.setText("");				
			}
			
			if(e.getSource()==equal)
			{
				 num2=Double.parseDouble(textfield.getText()) ;
				
				switch(operator)
					{
						case'+': result=num1+num2;
			 				 break;		
						
						case'-': result=num1-num2;
			 					break;

						case'*': result=num1*num2;
			 					break;

						case'/': result=num1/num2;
							 break;
					}
				textfield.setText(String.valueOf(result));
				num1=result;

			}


		}		
			


	public static void main(String args[])
	{
		calcSwing ob=new calcSwing();
	}
}

