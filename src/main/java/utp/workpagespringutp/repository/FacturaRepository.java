package utp.workpagespringutp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.workpagespringutp.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
