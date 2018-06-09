package lv.akurss.opinionshare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name = "seq_gen", sequenceName = "opinions_seq")
@Entity
@Table(name="opinions")
public class Opinion {

	@Id
	@GeneratedValue(generator = "seq_gen", strategy = GenerationType.SEQUENCE)
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

	@Column(name = "rating")
	private Long rating;

	@ManyToOne
	@JoinColumn(name = "topic_id")
	@JsonIgnore
	private Topic topic;

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

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
