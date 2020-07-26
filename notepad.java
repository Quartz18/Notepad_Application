import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.*;
class notepad extends JFrame implements ActionListener, WindowListener
{
	JMenuBar mb,m_format;
	JMenu mf,me,mfo,mc,m_font,m_style,m_size;
	JMenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18;
	JTextArea ta;
	JFileChooser fc;
	JScrollPane sp;
	String[] fonts;
	String f,st;int si;
	Font fonting;
	String sf="Fail", fail="Fail";
	note_font nf;
	notepad()
	{
		super("Untitled");
		mb=new JMenuBar();
		mf=new JMenu("File");
		m1=new JMenuItem("New");
		m1.addActionListener(this);
		m2=new JMenuItem("Open");
		m2.addActionListener(this);
		m3=new JMenuItem("Save");
		m3.addActionListener(this);
		m11=new JMenuItem("Save As");
		m11.addActionListener(this);
		m4=new JMenuItem("Exit");
		m4.addActionListener(this);
		me=new JMenu("Edit");
		m5=new JMenuItem("Cut");
		m5.addActionListener(this);
		m6=new JMenuItem("Copy");
		m6.addActionListener(this);
		m7=new JMenuItem("Paste");
		m7.addActionListener(this);
		mfo=new JMenu("Format");
		m10=new JMenuItem("Font");
		m10.addActionListener(this);
		mc=new JMenu("color");
		m9=new JMenuItem("Background");
		m9.addActionListener(this);
		m8=new JMenuItem("Foreground");
		m8.addActionListener(this);
		ta = new JTextArea();
		sp=new JScrollPane(ta);
		m_format=new JMenuBar();
		m_font=new JMenu("Font");
		mf.add(m1);mf.add(m2);mf.add(m3);mf.add(m11);mf.add(m4);
		me.add(m5);me.add(m6);me.add(m7);
		mc.add(m8);mc.add(m9);
		mfo.add(m10);mfo.add(mc);
		mb.add(mf);mb.add(me);mb.add(mfo);
		add(mb,BorderLayout.NORTH);
		add(sp);
		//ImageIcon icon = new ImageIcon("note.jpg");
		//setIconImage(icon.getImage());
		Image icon = Toolkit.getDefaultToolkit().getImage("note.jpg");  
		setIconImage(icon); 	
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==m1)
		{
			String t=getTitle();
			if(t.equals("Untitled"))
			{
				int i=JOptionPane.showConfirmDialog(null,"Do you want to save it?");
				if(i==0)
				{
					try
			{
				fc=new JFileChooser();
				fc.showSaveDialog(null);
				File f=fc.getSelectedFile();
				OutputStream ou=new FileOutputStream(f);
				String data=ta.getText();
				ou.write(data.trim().getBytes());
				setTitle(f.getName());
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
				}
				if(i==1)
				{
					ta.setText("");
				}
				if(i==2)
				{
					
				}
			}
		}
		if(e.getSource()==m2)
		{
			try
			{
				fc=new JFileChooser();
				fc.showOpenDialog(null);
				File f=fc.getSelectedFile();
				InputStream inn=new FileInputStream(f);int l=(int)f.length();
				byte[] b=new byte[l];
				inn.read(b);
				String data=new String(b);
				ta.setText(data);
				setTitle(f.getName());
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		if(e.getSource()==m3)
		{
			try
			{
				fc=new JFileChooser();
				fc.showSaveDialog(null);
				File f=fc.getSelectedFile();
				OutputStream ou=new FileOutputStream(f);
				String data=ta.getText();
				ou.write(data.trim().getBytes());
				setTitle(f.getName());
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		if(e.getSource()==m4)
		{
			dispose();
		}
		if(e.getSource()==m5)
		{
			ta.cut();
			
		}
		if(e.getSource()==m6)
		{
			ta.copy();
			
		}
		if(e.getSource()==m7)
		{
			ta.paste();
		}
		if(e.getSource()==m8)
		{
			JColorChooser cc=new JColorChooser();
			Color c=cc.showDialog(null,"Color",Color.red);
			ta.setForeground(c);
		}
		if(e.getSource()==m9)
		{
			JColorChooser cc=new JColorChooser();
			Color c=cc.showDialog(null,"Color",Color.red);
			ta.setBackground(c);
		}
		if(e.getSource()==m10)
		{
			try{
				nf = new note_font();
				nf.addWindowListener(this);
				
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
		}
		if(e.getSource()==m11)
		{
			int i=JOptionPane.showConfirmDialog(null,"Do you want to save it?");
			if(i==0)
			{
				try
			{
				fc=new JFileChooser();
				fc.showSaveDialog(null);
				File f=fc.getSelectedFile();
				OutputStream ou=new FileOutputStream(f);
				String data=ta.getText();
				ou.write(data.trim().getBytes());
				setTitle(f.getName());
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			}
			if(i==1)
			{
				ta.setText("");
			}
			if(i==2)
			{
					
			}
		}
		
	}
	public void windowActivated(WindowEvent arg0) {  
    	System.out.println("activated");  
	}  
	public void windowClosed(WindowEvent arg0) {  
				sf = nf.font();
				String[] arrSplit = sf.split("-");
			
				f=arrSplit[0];st=arrSplit[1];si=Integer.parseInt(arrSplit[2]);
				System.out.println(f);
				System.out.println(st);
				System.out.println(si);
				if(st.equals("BOLD"))
				{
				fonting = new Font(f,Font.BOLD,si);
				ta.setFont(fonting);
				
				}
				if(st.equals("ITALIC"))
				{
				fonting = new Font(f,Font.ITALIC,si);
				ta.setFont(fonting);
				}
				if(st.equals("PLAIN"))
				{
				fonting = new Font(f,Font.PLAIN,si);
				ta.setFont(fonting);
				}
	}  
	public void windowClosing(WindowEvent arg0) {  
	System.out.println("closing");  
    	dispose();  
	}  
	public void windowDeactivated(WindowEvent arg0) {  
        System.out.println("deactivated");  
	}  
	public void windowDeiconified(WindowEvent arg0) {  
	System.out.println("deiconified");  
	}  	
	public void windowIconified(WindowEvent arg0) {  
	System.out.println("iconified");  
	}  
	public void windowOpened(WindowEvent arg0) {  
	System.out.println("opened");  
	}  
	
	public static void main(String s[])
	{
		new notepad();
	}
}
