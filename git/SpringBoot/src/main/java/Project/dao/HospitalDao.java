package Project.dao;


import Project.domain.Hospital;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HospitalDao {
//    private int id;
//    private String openServiceName;
//    private int openLocalGovernmentCode;
//    private String managementNumber;

//     hospital.get licenseDate;
//     hospital.get businessStatus;
//     hospital.get businessStatusCode;
//     hospital.get phone;
//     hospital.get fullAddress;
//     hospital.get roadNameAddress;
//     hospital.get hospitalName;
//     hospital.get businessTypeName;
//     hospital.get healthcareProviderCount;
//     hospital.get patientRoomCount;
//     hospital.get totalNumberOfBeds;
//     hospital.get totalAreaSize;
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Hospital hospital){
        this.jdbcTemplate.update("insert into nation_wide_hospitals(id, open_service_name, open_local_government_code, management_number, license_date, business_status, business_status_code, phone, full_address, road_name_address, hospital_name, business_type_name, healthcare_provider_count, patient_room_count, total_number_of_beds, total_area_size) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);",
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
}
