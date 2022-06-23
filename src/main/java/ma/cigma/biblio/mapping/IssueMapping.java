package ma.cigma.biblio.mapping;

import ma.cigma.biblio.dto.IssueDto;
import ma.cigma.biblio.entities.Issue;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class IssueMapping {
    ModelMapper modelMapper=new ModelMapper();

    public IssueDto issueDtoToBo(Issue issue) {
        IssueDto issueDto=modelMapper.map(issue,IssueDto.class);
        return issueDto;
    }


    public Issue issueBoToDto(Issue issueDto) {
        Issue issue=modelMapper.map(issueDto, Issue.class);
        return issue;

    }
}
