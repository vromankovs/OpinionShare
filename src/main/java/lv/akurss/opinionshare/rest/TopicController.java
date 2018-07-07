package lv.akurss.opinionshare.rest;

import lv.akurss.opinionshare.model.Topic;
import lv.akurss.opinionshare.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {
	
	@Autowired 
	private TopicRepository topicRepository;

	
	@RequestMapping(path = "/topic", method = RequestMethod.POST)
	public void add(@RequestBody Topic topic) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		topic.setAuthor(auth.getName());
		topicRepository.save(topic);
	}
	
	@RequestMapping(path = "/topic", method = RequestMethod.GET)
	public List<Topic> getAll() {
		return topicRepository.findAll();
	}
	
	
}
