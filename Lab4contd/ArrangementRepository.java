package Lab4contd;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArrangementRepository extends CrudRepository<Arrangement, Long> {
  Arrangement findById(long id);
  List<Arrangement> findByAmount(int amount);
  List<Arrangement> findByDate(String date);
}

