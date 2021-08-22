package ar.com.educacionit.domain;

public class User extends Entity{

	private Long id;
	private String username;
	private String password;
	
	private Socios socios;
	
	public User(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Socios getSocios() {
		return socios;
	}

	public void setSocios(Socios socios) {
		this.socios = socios;
	}

	
}
