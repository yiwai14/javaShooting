import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;

public class KCtrlSKK extends KCtrl implements KConstant {

	private final int PHASE_INIT		= 0;
	private final int PHASE_TITLE		= 1;
	private final int PHASE_RUN			= 2;
	private final int PHASE_BOMB		= 3;
	private final int PHASE_END			= 4;
	private final int PHASE_STOP		= -1;

	private		KPanel				panel				= null;

	private		BufferedImage		imageBackground		= null;
	private		BufferedImage		imageTitle			= null;
	private		BufferedImage		imageShip			= null;
	private		BufferedImage		imageShipMini		= null;
	private		BufferedImage		imageBeam1			= null;
	private		BufferedImage		imageB01			= null;
	private		BufferedImage		imageB02			= null;
	private		BufferedImage		imageS01			= null;
	private		BufferedImage		imageS02			= null;
	private		BufferedImage		imageS03			= null;
	private		BufferedImage		imageS04			= null;
	private		BufferedImage		imageT01			= null;
	private		BufferedImage		imageT02			= null;
	private		BufferedImage		imageT03			= null;
	private		BufferedImage		imageT04_00			= null;
	private		BufferedImage		imageT04_01			= null;
	private		BufferedImage		imageT04_02			= null;
	private		BufferedImage		imageT05_00			= null;
	private		BufferedImage		imageT05_01			= null;
	private		BufferedImage		imageT05_02			= null;
	private		BufferedImage		imageT05_03			= null;
	private		BufferedImage		imageT06			= null;
	private		BufferedImage		imageT07_00			= null;
	private		BufferedImage		imageT07_01			= null;
	private		BufferedImage		imageT07_02			= null;
	private		BufferedImage		imageT07_03			= null;
	private		BufferedImage		imageT07_04			= null;
	private		BufferedImage		imageT07_05			= null;
	private		BufferedImage		imageT07_06			= null;
	private		BufferedImage		imageT07_07			= null;
	private		BufferedImage		imageT08_00			= null;
	private		BufferedImage		imageT08_01			= null;
	private		BufferedImage		imageT09			= null;
	private		BufferedImage		imageT99			= null;
	private		BufferedImage		imageJ01			= null;
	private		BufferedImage		imageJ02			= null;
	private		BufferedImage		imageJ03_00			= null;
	private		BufferedImage		imageJ03_01			= null;

	private		KSpriteBackground	spriteBackground0	= null;
	private		KSpriteBackground	spriteBackground1	= null;
	private		KSpriteTitle		spriteTitle			= null;
	private		KSpriteShip			spriteShip			= null;
	private		KSpriteShipMini		spriteShipMini		= null;

	private		KText				kTextStart			= null;
	private		KText				kTextBy				= null;
	private		KText				kTextEnd			= null;
	private		KText				kTextScoreHigh		= null;
	private		KText				kTextScore			= null;
	private		KTextShield			kTextShield			= null;
	private		KText				kTextStage			= null;
	private		KText				kTextTime			= null;

	private		int					phase				= PHASE_INIT;

	private		KStorySKK			kStorySKK			= null;

	private		int					score				= 0;

	private		int					scoreHigh			= 50000;

	private		int					stage				= 1;

	private		int					shield				= 5;

	private		String				strShield			= "����������";

	private		int					timeBomb			= 0;

	public KCtrlSKK(Container con){

		super(con);

		try{

			//
			panel = new KPanel(this);

			//
			panel.setLayoutCount(LAYOUT_COUNT);

			//
			kStorySKK = new KStorySKK(panel);

			//
			imageBackground = KImage.getImage("imageBackground.gif");
			imageTitle = KImage.getImage("imageTitle.gif");
			imageShip = KImage.getImage("imageShip.gif");
			imageShipMini = KImage.getImage("imageShipMini.gif");
			imageBeam1 = KImage.getImage("imageBeam1.gif");
			imageB01 = KImage.getImage("imageBomb1.gif");
			imageB02 = KImage.getImage("imageBomb2.gif");
			imageS01 = KImage.getImage("imageS01.gif");
			imageS02 = KImage.getImage("imageS02.gif");
			imageS03 = KImage.getImage("imageS03.gif");
			imageS04 = KImage.getImage("imageS04.gif");
			imageT01 = KImage.getImage("imageT01.gif");
			imageT02 = KImage.getImage("imageT01.gif");
			imageT03 = KImage.getImage("imageT03.gif");
			imageT04_00 = KImage.getImage("imageT04_00.gif");
			imageT04_01 = KImage.getImage("imageT04_01.gif");
			imageT04_02 = KImage.getImage("imageT04_02.gif");
			imageT05_00 = KImage.getImage("imageT05_00.gif");
			imageT05_01 = KImage.getImage("imageT05_01.gif");
			imageT05_02 = KImage.getImage("imageT05_02.gif");
			imageT05_03 = KImage.getImage("imageT05_03.gif");
			imageT06 = KImage.getImage("imageT06.gif");
			imageT07_00 = KImage.getImage("imageT07_00.gif");
			imageT07_01 = KImage.getImage("imageT07_01.gif");
			imageT07_02 = KImage.getImage("imageT07_02.gif");
			imageT07_03 = KImage.getImage("imageT07_03.gif");
			imageT07_04 = KImage.getImage("imageT07_04.gif");
			imageT07_05 = KImage.getImage("imageT07_05.gif");
			imageT07_06 = KImage.getImage("imageT07_06.gif");
			imageT07_07 = KImage.getImage("imageT07_07.gif");
			imageT08_00 = KImage.getImage("imageT08_00.gif");
			imageT08_01 = KImage.getImage("imageT08_01.gif");
			imageT09 = KImage.getImage("imageT09.gif");
			imageJ01 = KImage.getImage("imageJ01.gif");
			imageJ02 = KImage.getImage("imageJ02.gif");
			imageJ03_00 = KImage.getImage("imageJ03_00.gif");
			imageJ03_01 = KImage.getImage("imageJ03_01.gif");
			imageT99 = KImage.getImage("imageT99.gif");

			//
			KSpriteBackground.setImage(KSpriteBackground.class, imageBackground);
			KSpriteTitle.setImage(KSpriteTitle.class, imageTitle);
			KSpriteShip.setImage(KSpriteShip.class, new BufferedImage[]{imageShip, imageB01, imageB02});
			KSpriteShipMini.setImage(KSpriteShipMini.class, imageShipMini);
			KSpriteBeam1.setImage(KSpriteBeam1.class, imageBeam1);
			KSpriteS01.setImage(KSpriteS01.class, imageS01);
			KSpriteS02.setImage(KSpriteS02.class, imageS02);
			KSpriteS03.setImage(KSpriteS03.class, imageS03);
			KSpriteS04.setImage(KSpriteS04.class, imageS04);
			KSpriteT00.setImage(KSpriteT00.class, new BufferedImage[]{imageB01, imageB02});
			KSpriteT01.setImage(KSpriteT01.class, imageT01);
			KSpriteT02.setImage(KSpriteT02.class, imageT02);
			KSpriteT03.setImage(KSpriteT03.class, imageT03);
			KSpriteT04.setImage(KSpriteT04.class, new BufferedImage[]{imageT04_00, imageT04_01, imageT04_02});
			KSpriteT05.setImage(KSpriteT05.class, new BufferedImage[]{imageT05_00, imageT05_01, imageT05_02, imageT05_03});
			KSpriteT06.setImage(KSpriteT06.class, imageT06);
			KSpriteT07.setImage(KSpriteT07.class, new BufferedImage[]{imageT07_00, imageT07_01, imageT07_02, imageT07_03, imageT07_04, imageT07_05, imageT07_06, imageT07_07});
			KSpriteT08.setImage(KSpriteT08.class, new BufferedImage[]{imageT08_00, imageT08_01});
			KSpriteT09.setImage(KSpriteT09.class, imageT09);
			KSpriteT99.setImage(KSpriteT99.class, imageT99);
			KSpriteJ01.setImage(KSpriteJ01.class, imageJ01);
			KSpriteJ02.setImage(KSpriteJ02.class, imageJ02);
			KSpriteJ03.setImage(KSpriteJ03.class, new BufferedImage[]{imageJ03_00, imageJ03_01});

			//
			spriteBackground0 = new KSpriteBackground(panel);
			spriteBackground1 = new KSpriteBackground(panel);
			spriteTitle = new KSpriteTitle(panel);
			spriteShip = new KSpriteShip(panel);
			spriteShipMini = new KSpriteShipMini(panel);

			//
			panel.addSprite(LAYOUT_HOSI, spriteBackground0);
			panel.addSprite(LAYOUT_HOSI, spriteBackground1);

			//
			kTextStart = new KText(panel, 215, 400);
			kTextStart.setFont(new Font("MSゴシック", Font.PLAIN, 16));
			kTextStart.setText("PUSH SPACE KEY");

			kTextBy = new KText(panel, 230, 520);
			kTextBy.setFont(new Font("MSゴシック", Font.PLAIN, 12));
			kTextBy.setText("PROGRAMED  BY  KIN");

			kTextEnd = new KText(panel, 250, 300);
			kTextEnd.setFont(new Font("MSゴシック", Font.PLAIN, 16));
			kTextEnd.setText("GAME OVER");

			kTextScoreHigh = new KText(panel, 50, 20);
			panel.addText("HIGH-SCORE", kTextScoreHigh);

			kTextScore = new KText(panel, 200, 20);
			panel.addText("SCORE", kTextScore);

			kTextShield = new KTextShield(panel, 350, 20);
			panel.addText("SHIP", kTextShield);

			kTextStage = new KText(panel, 500, 20);
			panel.addText("STAGE", kTextStage);

			kTextTime = new KText(panel, 500, 40);
			panel.addText("TIME", kTextTime);

			spriteShipMini.setX(320);
			spriteShipMini.setY(4);

			spriteBackground1.setY(-600);

		}catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.toString());
		}

	} // end KCtrlSKK

	public void start(){

		//
		panel.requestFocus();

		//
		panel.start();

		//
		this.phase = PHASE_INIT;

	} // end start

	public void run(){

		//
		switch(this.phase){

			//
			case PHASE_INIT:

				//
				score = 0;

				//
				stage = 1;

				//
				shield = 5;
				strShield = "����������";

				//
				timeBomb = 0;

				//
				kStorySKK.reset();

				//
				panel.initKSpriteLstInLayout(LAYOUT_JIBUN);

				//
				panel.initKSpriteLstInLayout(LAYOUT_JIMEN);

				//
				panel.initKSpriteLstInLayout(LAYOUT_TEKI);

				//
				panel.initSpriteGroup();

				//
				panel.addSprite(LAYOUT_JIMEN, spriteTitle);
				panel.addText("START", kTextStart);
				panel.addText("BY", kTextBy);

				//
				kTextScore.setText("SCORE : " + Integer.toString(score));

				this.phase = PHASE_TITLE;

				break;

			//
			case PHASE_TITLE:

				//
				kTextScoreHigh.setText("HIGH-SCORE : " + Integer.toString(scoreHigh));

				//
				if(panel.isKeyCodePressed(KeyEvent.VK_SPACE)){

					//
					panel.removeSprite(LAYOUT_JIMEN, spriteTitle);
					panel.removeText("START");
					panel.removeText("BY");

					//
					spriteShip = new KSpriteShip(panel);

					//
					spriteShip.init();

					//
					panel.addSprite(LAYOUT_JIBUN, spriteShip);
					//
					panel.addSprite(LAYOUT_JIBUN, spriteShipMini);

					//
					kStorySKK.start();

					//
					this.phase = PHASE_RUN;

				}

				break;

			//
			case PHASE_RUN:

				//
				//
				//
				kStorySKK.next();

				//
				kTextScoreHigh.setText("HIGH-SCORE : " + Integer.toString(scoreHigh));

				kTextScore.setText("SCORE : " + Integer.toString(score));

				kTextStage.setText("STAGE : " + Integer.toString(stage));

				kTextTime.setText("TIME : " + kStorySKK.getStoryTime());

				kTextShield.setText(strShield);

				break;

			//
			case PHASE_BOMB:

				//
				kStorySKK.next();

				//
				kTextTime.setText("TIME : " + kStorySKK.getStoryTime());

				kTextShield.setText(strShield);

				//
				timeBomb++;

				//
				if(timeBomb > 200){

					//
					phase = PHASE_END;

					panel.addText("END", kTextEnd);

				}

				break;

			//
			case PHASE_END:

				//
				//
				//
				kStorySKK.next();

				//
				kTextTime.setText("TIME : " + kStorySKK.getStoryTime());

				//
				timeBomb++;

				//
				if(timeBomb > 500){

					panel.removeText("END");

					//
					phase = PHASE_INIT;

				}

				break;

			default:
				break;

		} // end switch

	} // end run

	public void addScore(int scoreAdd){

		this.score = this.score + scoreAdd;

		this.scoreHigh = (this.score > this.scoreHigh)?this.score: this.scoreHigh;

		kTextScoreHigh.setText("HIGH-SCORE : " + Integer.toString(scoreHigh));

		kTextScore.setText("SCORE : " + Integer.toString(score));

	} // end addScore

	public int getScore(){

		return this.score;

	} // end getScore

	public int addShield(int shieldAdd){

		//
		this.shield = this.shield + shieldAdd;

		StringBuilder sb = new StringBuilder();

		//
		for(int i = 0; i < this.shield; i++){
			sb.append("��");
		}

		strShield = sb.toString();

		//
		if(shieldAdd < 0){
			//
			kTextShield.damage();
		}

		//
		if(this.shield == 0){
			//
			phase = PHASE_BOMB;
		}

		//
		return this.shield;

	} // end addScore


	public int getShield(){

		return this.shield;

	} // end getShield

	public void restart(){

		//
		if(this.phase == PHASE_BOMB || this.phase == PHASE_END){

			//

		//
		}else{

			//
			this.phase = PHASE_RUN;

		}

	}

	public void stop(){

		//
		this.phase = PHASE_STOP;

	}

	public int getStage(){

		//
		return this.stage;

	}

	public void addStage(){

		//
		this.stage++;

	}

	public KPanel getKPanel(){

		//
		return this.panel;

	}


	public void gameover(){

		//
		phase = PHASE_END;

		panel.addText("END", kTextEnd);

	} // end gameover

}
