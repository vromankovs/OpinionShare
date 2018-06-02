package lv.akurss.opinionshare.repository;

import lv.akurss.opinionshare.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
