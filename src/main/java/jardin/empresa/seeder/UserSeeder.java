package jardin.empresa.seeder;

import jardin.empresa.auth.entity.UserEntity;
import jardin.empresa.model.RoleEntity;
import jardin.empresa.repository.RoleRepository;
import jardin.empresa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserSeeder implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void run(String... args) throws Exception {
        loadUser();
    }

    private void loadUser() {
        if(userRepository.count() == 0){
            loadUserEntity();
        }
    }

    private void loadUserEntity() {

        Collection<RoleEntity> admins = new ArrayList();
        if (roleRepository.count() == 0) {
            RoleEntity role = new RoleEntity(
                    "ROLE_ADMIN",
                    "Has the privileges from both roles");
            roleRepository.save(role);
            admins.add(role);
        }

        createUser("admin","admin@mail.com","123456", admins);

    }
    private void createUser(String name, String username, String password,  Collection<RoleEntity> roles) {

        UserEntity user = new UserEntity(
                name,
                username,
                passwordEncoder.encode(password),
                roles

        );
        userRepository.save(user);
    }

}
