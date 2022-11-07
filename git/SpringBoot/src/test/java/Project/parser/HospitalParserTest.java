package Project.parser;

import Project.dao.HospitalDao;
import Project.domain.Hospital;
import Project.service.HospitalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class HospitalParserTest {

    @Autowired      // @Configuration을 통해 설정한 Factory bean 파일 DI
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired      // @Component을 통해 설정한 HospitalDao bean 파일 DI
    HospitalDao hospitalDao;

    @Autowired      // @Service를 통해 설정한 HospitalService 파일 DI
    HospitalService hospitalService;
    String line1 = null;
    String filename = null;
    @BeforeEach
    void setup() {
        line1 = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100014\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";
        filename = "C:\\SpringBoot_DBFile\\fulldata_01_01_02_P_의원2.txt";

    }

//    @Test
//    @DisplayName("insert가 잘 되었는지 확인")
//    void add() throws IOException {
//        HospitalParser hp = new HospitalParser();
//        ReadLineContext rc = new ReadLineContext(hp);
//        List<Hospital> result;
//        result = rc.readByLine(filename);
//
//        for(int i =0; i<result.size(); i++) {
//            hospitalDao.add(result.get(i));
//        }
//    }

//    @Test
//    @DisplayName("모든 데이터 삭제 확인")
//    void deleteall(){
//        hospitalDao.deleteAll();
//    }
    
//    @Test
//    @DisplayName("데이터 갯수 세기")
//    void count(){
//        int num =hospitalDao.getcount();
//        assertEquals(2,num);
//    }
    
//    @Test
//    @DisplayName("10만건 이상 파싱이 되었는지 확인하고 몇개가 파싱됬는지 확인")
//    void name() throws IOException {
//        // 서버환경에서 build할 때 문제가 생길 수 있다.
//        // 어디에서든 실행할 수 있게 자는 것이 목표
//
//        //  hospitalDao.deleteAll();
//        int cnt = hospitalService.insertLargeVolumeHospitalData(filename);
//
//        assertTrue(cnt > 1000);
//        assertTrue(cnt > 10000);
//        System.out.printf("파싱된 데이터 개수 : %d",cnt);
//    }


//   @Test
//    @DisplayName("csv 1줄을 Hospital로 잘 만드는지 Test")
//    void converToHospital(){
//        HospitalParser hp = new HospitalParser();
//        Hospital hospital = hp.parse(line1);
//
//        assertEquals(1, hospital.getId()); // col:0
//        assertEquals("의원", hospital.getOpenServiceName());//col:1
//        assertEquals(3620000,hospital.getOpenLocalGovernmentCode()); // col: 3
//        assertEquals("PHMA119993620020041100004",hospital.getManagementNumber()); // col:4
//        assertEquals(LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLicenseDate()); //19990612 //col:5
//        assertEquals(1, hospital.getBusinessStatus()); //col:7
//        assertEquals(13, hospital.getBusinessStatusCode());//col:9
//        assertEquals("062-515-2875", hospital.getPhone());//col:15
//        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress()); //col:18
//        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());//col:19
//        assertEquals("효치과의원", hospital.getHospitalName());//col:21
//        assertEquals("치과의원", hospital.getBusinessTypeName());//col:25
//        assertEquals(1, hospital.getHealthcareProviderCount()); //col:29
//        assertEquals(0, hospital.getPatientRoomCount()); //col:30
//        assertEquals(0, hospital.getTotalNumberOfBeds()); //col:31
//        assertEquals(52.29f, hospital.getTotalAreaSize()); //col:32
//    }

}