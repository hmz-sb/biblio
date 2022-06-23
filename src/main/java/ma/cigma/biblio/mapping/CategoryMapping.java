package ma.cigma.biblio.mapping;


import ma.cigma.biblio.dto.CategoryDto;
import ma.cigma.biblio.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapping {

    ModelMapper modelMapper=new ModelMapper();

    public CategoryDto categoryDtoToBo(Category category) {
        CategoryDto categoryDto=modelMapper.map(category,CategoryDto.class);
        return categoryDto;
    }


    public Category categoryBoToDto(Category categoryDto) {
        Category category=modelMapper.map(categoryDto,Category.class);
        return category;

    }
}

