package ma.cigma.biblio.mapping;


import ma.cigma.biblio.dto.UserDto;
import ma.cigma.biblio.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapping {

    ModelMapper modelMapper=new ModelMapper();

    public UserDto userDtoToBo(User user) {
        UserDto userDto=modelMapper.map(user,UserDto.class);
        return userDto;
    }


    public User userBoToDto(User userDto) {
        User user=modelMapper.map(userDto,User.class);
        return user;

    }
}
