package ma.cigma.biblio.mapping;


import ma.cigma.biblio.dto.DocumentDto;
import ma.cigma.biblio.entities.Document;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapping {

    ModelMapper modelMapper=new ModelMapper();

    public DocumentDto documentDtoToBo(Document document) {
        DocumentDto documentDto =modelMapper.map(document, DocumentDto.class);
        return documentDto;
    }


    public Document documentBoToDto(Document documentDto) {
        Document document=modelMapper.map(documentDto, Document.class);
        return document;

    }
}

