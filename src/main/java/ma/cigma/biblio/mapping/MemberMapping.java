package ma.cigma.biblio.mapping;


import ma.cigma.biblio.dto.MemberDto;
import ma.cigma.biblio.entities.Member;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberMapping {

    ModelMapper modelMapper=new ModelMapper();

    public MemberDto memberDtoToBo(Member member) {
        MemberDto memberDto=modelMapper.map(member,MemberDto.class);
        return memberDto;
    }


    public Member memberBoToDto(Member memberDto) {
        Member member=modelMapper.map(memberDto,Member.class);
        return member;

    }

}
