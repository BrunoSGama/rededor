package desafio.rededor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio.rededor.model.Subnet;

@Repository
public interface SubnetRepository extends JpaRepository<Subnet, Long> {

}
