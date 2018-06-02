package lv.akurss.opinionshare.rest;

import lv.akurss.opinionshare.model.Opinion;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OpinionController {
	
	@RequestMapping(path = "/opinion/{topicId}", method = RequestMethod.POST)
	public void add(@PathVariable("topicId") Long topicId, @RequestBody Opinion opinion) {
		
	}

	@RequestMapping(path = "/opinion/{topicId}", method = RequestMethod.GET)
	public List<Opinion> getAll(@PathVariable("topicId") Long topicId) {
		return null;
	}
	
}
