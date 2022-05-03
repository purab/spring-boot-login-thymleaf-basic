package in.purabtech.logindemo.service;

import in.purabtech.logindemo.model.Users;
import in.purabtech.logindemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Users registerUser(String login, String password, String email) {
        if(login != null && password != null && email !=null) {
            Users users = new Users();
            users.setLogin(login);
            users.setPassword(password);
            users.setEmail(email);
            return usersRepository.save(users);

        } else {
            return null;
        }
    }

    public Users authenticate(String login, String password) {
        return usersRepository.findByLoginAndPassword(login,password).orElse(null);
    }
}
