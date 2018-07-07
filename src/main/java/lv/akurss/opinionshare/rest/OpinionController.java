package lv.akurss.opinionshare.rest;

import lv.akurss.opinionshare.model.Opinion;
import lv.akurss.opinionshare.model.Topic;
import lv.akurss.opinionshare.repository.OpinionRepository;
import lv.akurss.opinionshare.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class OpinionController {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private OpinionRepository opinionRepository;
	
	@RequestMapping(path = "/opinion/{topicId}", method = RequestMethod.POST)
	public void add(@PathVariable("topicId") Long topicId, @RequestBody Opinion opinion) {
		Optional<Topic> oTopic = topicRepository.findById(topicId);
		
		oTopic.ifPresent(topic -> {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			opinion.setAuthor(auth.getName());
			opinion.setRating(0L);
			opinion.setCreated(new Date());
			opinion.setUpdated(new Date());
			opinion.setTopic(topic);
			
			opinionRepository.save(opinion);
		});
	}

	@RequestMapping(path = "/opinion/{topicId}", method = RequestMethod.GET)
	public List<Opinion> getAll(@PathVariable("topicId") Long topicId) {
		Optional<Topic> oTopic = topicRepository.findById(topicId);
		
		return oTopic.map(topic -> {
			return opinionRepository.findAllByTopicOrderById(topic);
		}).orElse(new ArrayList<>());

	}
	
}
