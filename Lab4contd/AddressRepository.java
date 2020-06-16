package Lab4contd;


import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
  Address findById(long id);
}

