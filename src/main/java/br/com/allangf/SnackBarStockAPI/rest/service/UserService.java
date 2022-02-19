package br.com.allangf.SnackBarStockAPI.rest.service;

import br.com.allangf.SnackBarStockAPI.domain.entity.User;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.CredentialsDTO;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.TokenDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createNewUser(CredentialsDTO ccredentialsDTO);

    List<User> allUser();

    void deleteUser();

    TokenDTO authenticate(CredentialsDTO credentialsDTO);

    Optional<User> getUserLogged();

}
