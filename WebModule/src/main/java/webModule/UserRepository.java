package webModule;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
//@RepositoryRestResource(collectionResourceRel="users",path="users")

public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	Optional<UserModel> findByUsername(String username);
}
