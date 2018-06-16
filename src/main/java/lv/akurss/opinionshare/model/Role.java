package lv.akurss.opinionshare.model;

import javax.persistence.*;

@SequenceGenerator(name = "seq_gen", sequenceName = "roles_seq")
@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(generator = "seq_gen", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "role")
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
