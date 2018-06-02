package lv.akurss.opinionshare.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SequenceGenerator(name = "seq_gen", sequenceName = "topics_seq")
@Entity
@Table(name="topics")
public class Topic {

	@Id
	@GeneratedValue(generator="seq_gen", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "created")
	private Date created = new Date();

	@Column(name = "updated")
	private Date updated = new Date();

	@Version
	@Column(name = "version")
	private Long version;

	@Column(name = "author")
	private String author;
	
	@Column(name = "body", length = 4096)
	private String body;

	@OneToMany(mappedBy = "topic",
			cascade = CascadeType.ALL)
	private List<Opinion> opinions = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}
}
