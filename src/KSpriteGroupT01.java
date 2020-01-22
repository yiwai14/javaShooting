
public class KSpriteGroupT01 extends KSpriteGroup implements KConstant {

	private		int			pos			= -1;

	private		String		storyParam	= null;

	public KSpriteGroupT01(KPanel panel, String storyParam){
		super(panel);
		this.storyParam = storyParam;
	}

	public void run(){

		//
		if((time % 30) == 0){
			pos++;
			//
			KSpriteT01 kSpriteT01 = new KSpriteT01(super.getKPanel(), pos, storyParam);
			//
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT01);
		}

		//
		if(time == 300){
			//
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
