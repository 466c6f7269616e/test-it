package com.example.testit.adapter.user;

import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Implémentation fake pour simuler un système d'authentification.
 * Permet de définir un utilisateur "connecté" pour les tests ou développement local,
 * sans nécessiter un système d'authentification réel (comme JWT ou sessions).
 */
@Service
public class CurrentUserServiceFake implements CurrentUserService {

    /** ID de l'utilisateur simulé comme étant "connecté". */
    private Long current;

    /**
     * Retourne l'ID de l'utilisateur actuellement simulé comme connecté.
     * @return un Optional contenant l'ID si défini, empty sinon
     */
    @Override
    public Optional<Long> getCurrentUserId() {
        return Optional.ofNullable(current);
    }


    public void setCurrent(Long current) {
        this.current = current;
    }


    public Long getCurrent() {
        return current;
    }
}
