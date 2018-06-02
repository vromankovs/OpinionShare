package lv.akurss.opinionshare.repository;

import lv.akurss.opinionshare.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
