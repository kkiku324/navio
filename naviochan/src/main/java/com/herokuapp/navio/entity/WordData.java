package com.herokuapp.navio.entity;


/**
 * ���ԍ��A�p�P��Ƃ��̈Ӗ���ێ�����G���e�B�e�B�N���X
 */
public class WordData {
	
	/**
	 * ���ԍ�
	 */
	private int questionNumber;
	
	/**
	 * �p�P��
	 */
	private String word;
	
	/**
	 * �p�P��̈Ӗ��i���{���j
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
