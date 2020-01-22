import java.util.*;

public class KSpriteT04 extends KSpriteT00 implements KConstant {

	private final int PHASE_START = 0;

	private final int PHASE_CHASE = 1;

	private int phase = PHASE_START;

	private int mx = 0;

	public KSpriteT04(KPanel panel){

		super(panel);

		//
		intX = (int)(Math.random() * (panel.getWidth() - getWidth()));

		intY = -getHeight();

	} // end KSpriteT04

	public void run(){

		//
		super.run();

		//
		switch(phase){

			//
			case PHASE_START:

				//
				intY = intY + 4;

				//
				if(intY > HEIGHT){
					//
					super.removeSprite();
				}

				//
				ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

				//
				KSprite sprite = spriteLst.get(0);

				//
				if(intY > sprite.getY()){

					//
					phase = PHASE_CHASE;

					//
					if(intX < sprite.getX()){

						//
						mx = 5;

						//
						setImage(KSpriteT04.class, 1);

					//
					}else{

						//
						mx = -5;

						//
						setImage(KSpriteT04.class, 2);

					} // end if

				} // end if

				//
				break;

			//
			case PHASE_CHASE:

				//
				intX = intX + mx;

				//
				if(intX > WIDTH){
					//
					super.removeSprite();
				}

				//
				if(intX < 0){
					//
					super.removeSprite();
				}

			default:
				//
				break;

		} // end switch

	} // end run

	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
