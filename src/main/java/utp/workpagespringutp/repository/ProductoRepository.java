package utp.workpagespringutp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.workpagespringutp.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
