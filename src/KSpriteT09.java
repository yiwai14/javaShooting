
public class KSpriteT09 extends KSpriteT00 implements KConstant {

	private	final	int	PHASE_1	= 1;
	private	final	int	PHASE_2	= 2;

	private		int		phase	= PHASE_1;

	private		float	floatX	= 0;

	private		float	mX		= 0;

	public KSpriteT09(KPanel panel, int intX){

		super(panel);

		this.intX = intX;

		//
		this.intY = HEIGHT;

	} // end KSpriteT09

	public void run(){

		//
		super.run();

		//
		if(phase == PHASE_1){

			//
			intY = intY - 4;

			//
			if(super.getY() <= 0){

				//
				phase = PHASE_2;

				//
				floatX = (float)super.getX();

				mX = (int)(Math.random() * 10) * ((super.getX() == 0)?1: -1);

			} // end if

		//
		}else{

			//
			intY = intY + 6;

			floatX = floatX + mX;

			//
			intX = (int)floatX;

			//
			if(intY > HEIGHT){
				//
				super.removeSprite();
			}

		} // end if

	} // end run

	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(200);

		super.bomb();

	} // end bomb

}
