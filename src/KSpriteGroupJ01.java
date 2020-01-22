public class KSpriteGroupJ01 extends KSpriteGroup implements KConstant {

	public KSpriteGroupJ01(KPanel panel){
		super(panel);
	}

	public void run(){

		// 一定時間経過の場合、
		if((time % 16) == 0){
			for(int i = 0; i < 600; i = i + 32){
				KSpriteJ01 kSpriteJ01 = new KSpriteJ01(super.getKPanel(), i);
				super.getKPanel().addSprite(LAYOUT_JIMEN, kSpriteJ01);
			}
		}

		// 4回出たら、
		if(time >= 64){
			super.getKPanel().removeSpriteGroup(this);
		}

	}

}
