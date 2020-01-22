
public class KSpriteGroupT04 extends KSpriteGroup implements KConstant {

	public KSpriteGroupT04(KPanel panel){
		super(panel);
	}

	public void run(){

		//
		if((time % 40) == 0){
			//
			KSpriteT04 kSpriteT04 = new KSpriteT04(super.getKPanel());
			//
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT04);
		}

		//
		if(time == 360){
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
