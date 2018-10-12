import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppGraphInOut {
	public class void main(String args[]) {
		new AppFrame();
	}
}
class AppFrame extends JFrame {
	JTextFile in = new JTextFile(10);
	JButton btn = new JButton("求平方");
	JLabel out = new JLabel("用于显示结果的标签");

	public AppFrame()
	{
		setlayout( new FlowLayout() );
		setContenPane().add(in);
		setContenPane().add(btn);
		setContenPane().add(out);
		btn.addActionListener( new BtnActionAdapter() );
		setSize(400,100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	class BtnActionAdapter implements ActionListener
	{
		public void actionPerformed( ActionEvent e)
		{
			String s = in.getText();
			double d = Double.parseDouble(s);
			double sq = d * d;
			out.setText( d + "的平方是：" + sq );

		}
	}

}