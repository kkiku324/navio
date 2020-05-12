package com.herokuapp.navio.entity;


/**
 * 1問分の問題データを保持するエンティティクラス
 */
public class WordData {
	
	/**
	 * 問題番号
	 */
	private int questionNumber;
	
	/**
	 * 英単語
	 */
	private String word;
	
	/**
	 * 意味
	 */
	private String meaning;
	
	public WordData() { }

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
}
