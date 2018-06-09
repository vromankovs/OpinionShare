package lv.akurss.opinionshare.repository;

import lv.akurss.opinionshare.model.Opinion;
import lv.akurss.opinionshare.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {

	List<Opinion> findAllByTopicOrderById(Topic topic);

}
