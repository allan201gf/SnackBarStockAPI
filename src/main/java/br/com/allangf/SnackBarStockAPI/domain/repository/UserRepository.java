package br.com.allangf.SnackBarStockAPI.domain.repository;

import br.com.allangf.SnackBarStockAPI.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);


}
