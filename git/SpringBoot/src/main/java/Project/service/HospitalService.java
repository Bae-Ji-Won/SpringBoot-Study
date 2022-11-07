package Project.service;

import Project.dao.HospitalDao;
import Project.domain.Hospital;
import Project.parser.ReadLineContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

// 매번 test할때마다 대용량 데이터를 DB에 삽입하는 것이 비효율적이기 때문에 service에
@Service
public class HospitalService {

    private final ReadLineContext<Hospital> hospitalReadLineContext;        // ReadLineContext 클래스 사용하기 위해
    
    private final HospitalDao hospitalDao;          // HospitalDao 사용하기 위해

    public HospitalService(ReadLineContext<Hospital> hospitalReadLineContext, HospitalDao hospitalDao) {
        this.hospitalReadLineContext = hospitalReadLineContext;
        this.hospitalDao = hospitalDao;
    }

    /*  위의 코드는 아래와 같은 의미
    @Autowired
    private final ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired
    private final HospitalDao hospitalDao;   
     */
    

    // 반영된 개수를 반환함
    @Transactional          // 성능을 좀더 높여줌
    public int insertLargeVolumeHospitalData(String filename){
        int cnt = 0;
        try {
            List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
            System.out.println("파싱이 끝났습니다.");
            for(Hospital hospital: hospitalList){   // loop 구간
                try {
                    this.hospitalDao.add(hospital);     // db에 insert하는 구간
                    cnt++;
                } catch (Exception e) {
                    System.out.printf("id:%d 레코드에 문제가 있습니다.",hospital.getId());
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cnt;
    }
}
