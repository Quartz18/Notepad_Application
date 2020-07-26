import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.*;
class note_font extends JFrame implements ActionListener
{
	String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(),style[] = {"BOLD","ITALIC","PLAIN","BOLD ITALIC"},
	size[] = {"8","9","10","11","12","14","16","20","22","24","26","28"};
	JComboBox cb1,cb2,cb3;
	JTextField t1;
	JLabel l1,l2,l3,l4;
	JPanel p1,p2,p3;
	JButton b1,b2;
	Object of,ot,oi;
	String f,st;
	Font fonting;
	int si;
	String cf,ct,ci,forma="Chandas-BOLD-12";
	note_font()
	{
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		l1=new JLabel("Font:");
		cb1=new JComboBox<>(fonts); 
		l2=new JLabel("Style:");
		cb2=new JComboBox<>(style);
		l3=new JLabel("Size:");
		cb3=new JComboBox<>(size);
		l4=new JLabel("Sample");
		l4.setBackground(Color.WHITE);
		b1=new JButton("OK");
		b1.addActionListener(this);
		b2=new JButton("Cancel");
		b2.addActionListener(this);
		p1.add(cb1);p1.add(cb2);p1.add(cb3);p2.add(l4);p3.add(b1);p3.add(b2);
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		setSize(400,200);
		setTitle("Font");  
    		setVisible(true);   
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
		of=cb1.getSelectedItem();
		ot=cb2.getSelectedItem();
		oi=cb3.getSelectedItem();
		cf=(String)of;ct=(String)ot;ci=(String)oi;
		forma=cf+"-"+ct+"-"+ci;
		String[] arrSplit = forma.split("-");	
		f=arrSplit[0];st=arrSplit[1];si=Integer.parseInt(arrSplit[2]);
		System.out.println(f);
		System.out.println(st);
		System.out.println(si);
		if(st.equals("BOLD"))
		{
		fonting = new Font(f,Font.BOLD,si);
		l4.setFont(fonting);
		}
		if(st.equals("ITALIC"))
		{
		fonting = new Font(f,Font.ITALIC,si);
		l4.setFont(fonting);
		}
		if(st.equals("PLAIN"))
		{
		fonting = new Font(f,Font.PLAIN,si);
		l4.setFont(fonting);
		}
		if(st.equals("BOLD ITALIC"))
		{
		fonting = new Font(f,Font.PLAIN,si);
		l4.setFont(fonting);
		}
		}
		if(e.getSource()==b2)
		{
		dispose();
		}
		
	}
	public String font()
	{
		forma=cf+"-"+ct+"-"+ci;
		return forma;
	}
	public static void main(String s[])
	{
		new note_font();
	}
}
