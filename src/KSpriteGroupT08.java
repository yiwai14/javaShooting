
public class KSpriteGroupT08 extends KSpriteGroup implements KConstant {

	public KSpriteGroupT08(KPanel panel){
		super(panel);
	}

	public void run(){

		//
		if((time % 10) == 0){
			//
			KSpriteT08 kSpriteT08 = new KSpriteT08(super.getKPanel());
			//
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT08);
		}

		//
		if(time >= 290){
			//
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
