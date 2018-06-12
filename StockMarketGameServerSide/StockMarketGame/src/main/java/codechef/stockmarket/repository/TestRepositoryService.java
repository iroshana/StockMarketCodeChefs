package codechef.stockmarket.repository;

import codechef.stockmarket.entity.Test;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepositoryService extends JpaRepository<Test, Long> {
    List<Test> findAllByUserNAme(String Name);
}
