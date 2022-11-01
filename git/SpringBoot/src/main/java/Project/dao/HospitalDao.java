package Project.dao;


import Project.domain.Hospital;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class HospitalDao {
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // select 구문으로 받은 객체를 자신이 원하는 형태로 받을수 있도록 rowMapper함
    RowMapper<Hospital> rowMapper = new RowMapper<Hospital>() {
        @Override
        public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
            LocalDate dt = rs.getDate("licenced_date").toLocalDate();
            return null;
        }
    };

    public void add(Hospital hospital){
        this.jdbcTemplate.update("insert into nation_wide_hospitals(id, open_service_name, open_local_government_code, management_number, license_date, business_status, business_status_code, phone, full_address, road_name_address, hospital_name, business_type_name, healthcare_provider_count, patient_room_count, total_number_of_beds, total_area_size) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);",
                hospital.getId(),
                hospital.getOpenServiceName(),
                hospital.getOpenLocalGovernmentCode(),
                hospital.getManagementNumber(),
                hospital.getLicenseDate(),
                hospital.getBusinessStatus(),
                hospital.getBusinessStatusCode(),
                hospital.getPhone(),
                hospital.getFullAddress(),
                hospital.getRoadNameAddress(),
                hospital.getHospitalName(),
                hospital.getBusinessTypeName(),
                hospital.getHealthcareProviderCount(),
                hospital.getPatientRoomCount(),
                hospital.getTotalNumberOfBeds(),
                hospital.getTotalAreaSize());
    }

    public int getcount(){
        return this.jdbcTemplate.queryForObject("select count(id) from nation_wide_hospitals", Integer.class); // integer로 반환
    }
    // this.jdbcTemplate.queryForObject(sql,어떤 자료형으로 내보낼지 정함)
    // queryForObject(sql,String.class)를 사용했을 때 String으로 return되는 것을 확인

    public void deleteAll(){
        this.jdbcTemplate.update("delete from nation_wide_hospital");
    }
}
