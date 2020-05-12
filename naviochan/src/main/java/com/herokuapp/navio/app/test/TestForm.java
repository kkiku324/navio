package com.herokuapp.navio.app.test;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * �P��e�X�g�쐬�t�H�[���ɑΉ�����t�H�[���N���X
 */
public class TestForm {
	@Min(1)
	@Max(999)
	private int startPosition;  // �J�n�ʒu�̔ԍ�
	
	@Min(1)
	@Max(999)
	private int endPosition;  // �I���ʒu�̔ԍ�
	
	public TestForm() { }

	public int getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}

	public int getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(int endPosition) {
		this.endPosition = endPosition;
	}
}
