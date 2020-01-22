public class KSpriteGroupT07 extends KSpriteGroup implements KConstant {

	private		String		storyParam	= null;

	public KSpriteGroupT07(KPanel panel, String storyParam){
		super(panel);
		this.storyParam = storyParam;
	}

	public void run(){

		//
		if((time % 30) == 0){
			//
			KSpriteT07 kSpriteT07 = new KSpriteT07(super.getKPanel(), storyParam);
			//
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT07);
		}

		//
		if(time == 300){
			//
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
