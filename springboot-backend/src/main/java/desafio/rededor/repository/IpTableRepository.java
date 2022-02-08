package desafio.rededor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio.rededor.model.IpTable;

@Repository
public interface IpTableRepository extends JpaRepository<IpTable, Long> {

}
