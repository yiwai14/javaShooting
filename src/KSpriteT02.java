
public class KSpriteT02 extends KSpriteT00 implements KConstant {

	private		int			beamY		= -1;

	private		boolean		flgBeam		= false;

	public KSpriteT02(KPanel panel, int pos, String storyParam){

		super(panel);

		//
		intX = panel.getWidth() - (pos + 1) * (panel.getWidth() / 11);

		intY = -getHeight();

		//
		if(storyParam != null){
			//
			beamY = Integer.parseInt(storyParam);
		}

	} // end KSpriteT02

	public void run(){

		//
		super.run();

		//
		intY = intY + 4;

		//
		if(intY > HEIGHT){
			//
			super.removeSprite();
		}

		//
		if(!flgBeam && beamY != -1 && intY > beamY){

			//
			flgBeam = true;

			KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, 6);
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

		} // end if

	} // end run

	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
