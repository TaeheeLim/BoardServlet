package kr.or.ddit.vo;

public class EarningVO {
	private int earning_index;
	private String earning_date;
	private int charge;
	private String member_mail;
	
	public EarningVO() {}

	public EarningVO(int earning_index, String earning_date, int charge, String member_mail) {
		super();
		this.earning_index = earning_index;
		this.earning_date = earning_date;
		this.charge = charge;
		this.member_mail = member_mail;
	}

	public int getEarning_index() {
		return earning_index;
	}

	public void setEarning_index(int earning_index) {
		this.earning_index = earning_index;
	}

	public String getEarning_date() {
		return earning_date;
	}

	public void setEarning_date(String earning_date) {
		this.earning_date = earning_date;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public String getMember_mail() {
		return member_mail;
	}

	public void setMember_mail(String member_mail) {
		this.member_mail = member_mail;
	};
	
	
}
