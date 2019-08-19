package liftoffproject.futurevision.models.data;

import liftoffproject.futurevision.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClientDao extends CrudRepository<Client, Integer> {
}
