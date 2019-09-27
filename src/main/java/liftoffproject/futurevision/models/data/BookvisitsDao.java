package liftoffproject.futurevision.models.data;

import liftoffproject.futurevision.models.Bookvisits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookvisitsDao extends CrudRepository <Bookvisits, Integer> {
}
