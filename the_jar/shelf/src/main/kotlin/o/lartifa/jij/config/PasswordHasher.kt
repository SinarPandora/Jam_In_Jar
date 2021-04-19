package o.lartifa.jij.config

import at.favre.lib.crypto.bcrypt.BCrypt
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces

@ApplicationScoped
class PasswordHasher {
    /**
     * Password hasher
     */
    @Produces
    fun hasher(): BCrypt.Hasher = BCrypt.withDefaults()
    
    @Produces
    fun verifyer(): BCrypt.Verifyer = BCrypt.verifyer()
}
