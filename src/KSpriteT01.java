/**
 * �G�P.
 */
public class KSpriteT01 extends KSpriteT00 implements KConstant {

	/**
	 * �r�[�����˃t���O.
	 */
	private		boolean		flgBeam		= false;

	/**
	 * �r�[�����ˈʒu.
	 */
	private		int			beamY		= -1;

	/**
	 * �R���X�g���N�^.
	 * @param panel KPanel
	 * @param pos �ґ��|�W�V����
	 * @param storyParam �r�[�����ˈʒu
	 */
	public KSpriteT01(KPanel panel, int pos, String storyParam){

		super(panel);

		// X�ʒu�F�ґ��|�W�V������ݒ�
		intX = pos * (panel.getWidth() / 11);

		intY = -getHeight();

		// �r�[�����ˈʒu���ݒ肳��Ă���ꍇ�A
		if(storyParam != null){
			beamY = Integer.parseInt(storyParam);
		}

	} // end KSpriteT01

	/**
	 * ���s.
	 * <pre>
	 * ���I�u�W�F�N�g�̂ӂ�܂������肵�܂��B
	 * <pre>
	 */
	public void run(){

		// �e�N���X�����s����
		super.run();

		// �O�i
		intY = intY + 4;

		// ��ʂ̊O�ɏo���ꍇ�A
		if(intY > HEIGHT){
			// �X�v���C�g������
			super.removeSprite();
		}

		// �r�[���𔭎˂���ꍇ�A
		if(!flgBeam && beamY != -1 && intY > beamY){

			// �r�[������
			flgBeam = true;

			KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, 6);
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

		} // end if  �r�[���𔭎˂���ꍇ

	} // end run

	/**
	 * ����.
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
