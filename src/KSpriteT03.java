
public class KSpriteT03 extends KSpriteT00 implements KConstant {

	public KSpriteT03(KPanel panel){

		super(panel);

		//
		intX = (int)(Math.random() * (panel.getWidth() - getWidth()));

		intY = -getHeight();

	} // end KSpriteT03

	public void run(){

		//
		super.run();

		//
		intY = intY + 6;

		//
		if(intY > HEIGHT){
			//
			super.removeSprite();
		}

	} // end run

	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(50);

		super.bomb();

	} // end bomb

}
