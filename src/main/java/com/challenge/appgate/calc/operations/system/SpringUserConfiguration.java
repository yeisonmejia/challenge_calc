package com.challenge.appgate.calc.operations.system;

import com.challenge.appgate.calc.operations.actions.UserCreator;
import com.challenge.appgate.calc.operations.infrastructure.InMemoryUserRespository;
import com.challenge.appgate.calc.operations.model.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringUserConfiguration {

    @Bean
    UserRepository userRepository(InMemoryDataBase inMemoryDataBase){
        return new InMemoryUserRespository(inMemoryDataBase);
    }

    @Bean
    UserCreator userCreator (UserRepository userRepository) {
        return new UserCreator(userRepository);
    }
}
