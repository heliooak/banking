package com.bank.api.dto;


public class AtualizaStatusDTO {
	private String status;

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AtualizaStatusDTO() {
		super();
	}
	
	public AtualizaStatusDTO(String status) {
		super();
		this.status = status;
	}

	@Override
	public String toString() {
		return "AtualizaStatusDTO [status=" + status + "]";
	}
	
	
	
}


