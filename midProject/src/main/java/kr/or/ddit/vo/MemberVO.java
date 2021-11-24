package kr.or.ddit.vo;

public class MemberVO {
	private String member_mail;
	private String firstname;
	private String lastname;
	private String nickname;
	private String member_date;
	private String password;
	private String regedent_num;
	private String introduction;
	private String profileimg;
	private String freezedate;
	private String master;
	
	public MemberVO() {}
	
	
	public MemberVO(String member_mail, String firstname, String lastname, String nickname, String member_date,
			String password, String regedent_num, String introduction, String profileimg, String freezedate, String master) {
		super();
		this.member_mail = member_mail;
		this.firstname = firstname;
		this.lastname = lastname;
		this.nickname = nickname;
		this.member_date = member_date;
		this.password = password;
		this.regedent_num = regedent_num;
		this.introduction = introduction;
		this.freezedate = freezedate;
		this.master = master;
		this.profileimg = profileimg;
	}
	public String getMember_mail() {
		return member_mail;
	}
	public void setMember_mail(String member_mail) {
		this.member_mail = member_mail;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMember_date() {
		return member_date;
	}
	public void setMember_date(String member_date) {
		this.member_date = member_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegedent_num() {
		return regedent_num;
	}
	public void setRegedent_num(String regedent_num) {
		this.regedent_num = regedent_num;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getFreezedate() {
		return freezedate;
	}
	public void setFreezedate(String freezedate) {
		this.freezedate = freezedate;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}


	public String getProfileimg() {
		return profileimg;
	}


	public void setProfileimg(String profileimg) {
		this.profileimg = profileimg;
	}
	
	
}
