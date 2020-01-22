import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KFrameSKK extends JFrame implements KConstant {

	KCtrlSKK	kCtrl		= null;
	KPanel		kPanel		= null;

	public static void main(String[] args){
		KFrameSKK test = new KFrameSKK();
	}

	public KFrameSKK(){

		super();

		super.setSize(KConstant.WIDTH, KConstant.HEIGHT);
		super.setLayout(new BorderLayout());
		super.addWindowListener(new KFrameWindowAdapter());

		KImage.setContainer(this);

		kCtrl = new KCtrlSKK(this);
		kPanel = kCtrl.getKPanel();

		super.setTitle("SKK");

		super.setContentPane(kPanel);

		super.setVisible(true);
		super.requestFocus();

		kCtrl.start();

	}

	private class KFrameWindowAdapter extends WindowAdapter {

		public void windowClosing(WindowEvent we){
			System.exit(0);
		}

	}

}
