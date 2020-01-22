

public class KSpriteGroupT02 extends KSpriteGroup implements KConstant {

	private		int			pos			= -1;

	private		String		storyParam	= null;

	public KSpriteGroupT02(KPanel panel, String storyParam){
		super(panel);
		this.storyParam = storyParam;
	}

	public void run(){

		// A
		if((time % 30) == 0){
			pos++;
			//
			KSpriteT02 kSpriteT02 = new KSpriteT02(super.getKPanel(), pos, storyParam);
			//
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT02);
		}

		//
		if(time == 300){
			//
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
