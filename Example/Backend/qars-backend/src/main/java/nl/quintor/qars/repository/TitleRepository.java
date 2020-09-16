package nl.quintor.qars.repository;

import nl.quintor.qars.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends CrudRepository<Title, Integer> {

}
