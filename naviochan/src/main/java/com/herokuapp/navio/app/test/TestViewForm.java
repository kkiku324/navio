package com.herokuapp.navio.app.test;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * テストフォームの入力値を保持するエンティティクラス
 */
public class TestViewForm {
	@Min(1)
	@Max(1900)
	private int startPosition;  // 開始位置の番号
	
	@Min(1)
	@Max(1900)
	private int endPosition;  // 終了位置の番号
	
	public TestViewForm() { }

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
