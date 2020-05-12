package com.herokuapp.navio.entity;


/**
 * 問題番号、英単語とその意味を保持するエンティティクラス
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
	 * 英単語の意味（日本語訳）
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
