package ar.com.educacionit.domain;

public class Newsletter {

	private Long id;
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Newsletter [id=" + id + ", email=" + email + "]";
	}
	
}
