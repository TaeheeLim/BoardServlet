package kr.or.ddit.vo;

public class SeedVO {
	private int seed_index;
	private String mamber_mail;
	private int seed;
	private String seed_date;
	private String seed_state;
	
	public SeedVO() {};
	
	public SeedVO(int seed_index, String member_mail, int seed, String seed_date, String seed_state) {
		super();
		this.seed_index = seed_index;
		this.mamber_mail = member_mail;
		this.seed = seed;
		this.seed_date = seed_date;
		this.seed_state = seed_state;
	}

	public int getSeed_index() {
		return seed_index;
	}

	public void setSeed_index(int seed_index) {
		this.seed_index = seed_index;
	}

	public String getMember_mail() {
		return mamber_mail;
	}

	public void setMember_mail(String member_mail) {
		this.mamber_mail = member_mail;
	}

	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public String getSeed_date() {
		return seed_date;
	}

	public void setSeed_date(String seed_date) {
		this.seed_date = seed_date;
	}

	public String getSeed_state() {
		return seed_state;
	}

	public void setSeed_state(String seed_state) {
		this.seed_state = seed_state;
	}
	
	
	
	
	
	
}
