package Project.parser;

import Project.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserFactory {


    // Bean은 HospitalParser와 ReadLineContext파일을 합쳐서 하나의 완성품을 만들어 놓은 상태이다
    // 그래서 이것을 test에서 autowired를 통해 한번에 사용할수 있도록 즉, test에서는 hospitalparser와 readlinecontext 파일에
    // 접근을 안하고 bean파일만 호출하여 모든 것을 사용할 수 있도록 한것이다.
    @Bean
    public ReadLineContext<Hospital> hospitalReadLineContext(){
        return new ReadLineContext<Hospital>(new HospitalParser());
    }
}
