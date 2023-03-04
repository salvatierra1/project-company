package jardin.empresa.repository;


import jardin.empresa.model.Galeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GaleriaRepository extends JpaRepository<Galeria, Long> {
}
