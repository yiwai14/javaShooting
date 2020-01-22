import java.awt.*;
import java.applet.*;
import javax.swing.*;

public class KAppletSKK extends Applet {

	public KAppletSKK(){

		super();

	}

	public void start(){

		try{

			KImage.setApplet(this);

			KCtrlSKK kCtrlSKK = new KCtrlSKK(this);

			this.setLayout(new BorderLayout());

			this.add(kCtrlSKK.getKPanel(), BorderLayout.CENTER);

			kCtrlSKK.start();

		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}

	}


}
