package com.asd.activos.model;

import java.util.List;

import com.asd.activos.enumerator.ResponseModelEnum;
import com.asd.activos.persistence.entities.ActivosEntity;

public class ResponseModel {
	private Long code;
	private String answer;
	private List<ActivosEntity> body;
	
	public ResponseModel() {
		super();
	}

	public ResponseModel(String answer) {
		super();
		this.answer = answer;
	}
	
	public ResponseModel(Long code, String answer) {
		super();
		this.code = code;
		this.answer = answer;
	}
	
	public ResponseModel(ResponseModelEnum responseModelEnum){
		this.code = responseModelEnum.getCode();
		this.answer = responseModelEnum.getDescription();
	}

	/**
	 * @param code
	 * @param answer
	 * @param body
	 */
	public ResponseModel(Long code, String answer, List<ActivosEntity> body) {
		super();
		this.code = code;
		this.answer = answer;
		this.body = body;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseModel : [code=");
		builder.append(code);
		builder.append("][answer=");
		builder.append(answer);
		builder.append("][body=");
		builder.append(body);
		builder.append("]");
		return builder.toString();
	}
	

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * @return the body
	 */
	public List<ActivosEntity> getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(List<ActivosEntity> body) {
		this.body = body;
	}
	
	
}
