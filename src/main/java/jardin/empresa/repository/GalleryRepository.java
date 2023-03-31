package jardin.empresa.repository;


import jardin.empresa.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
