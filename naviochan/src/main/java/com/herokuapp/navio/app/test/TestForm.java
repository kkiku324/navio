package com.herokuapp.navio.app.test;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 単語テスト作成フォームに対応するフォームクラス
 */
public class TestForm {
	@Min(1)
	@Max(999)
	private int startPosition;  // 開始位置の番号
	
	@Min(1)
	@Max(999)
	private int endPosition;  // 終了位置の番号
	
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
