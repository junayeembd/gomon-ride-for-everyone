package com.gomon.model;

public class Driver extends User {

    private String nid;
    private String drivingLicense;
    private String vehicleType;
    private String vehicleNumber;
    private String workTime;

    // Default Constructor
    public Driver() {
        super(); 
    }

    // Parameterized Constructor
    public Driver(int id,
            String fullName,
            String username,
            String email,
            String phone,
            String address,
            String password,
            String role,
            String status,
            java.time.LocalDateTime createdAt,
            String nid,
            String drivingLicense,
            String vehicleType,
            String vehicleNumber,
            String workTime) {

        super(id, fullName, username, email, phone, address,
                password, role, status, createdAt);

        this.nid = nid;
        this.drivingLicense = drivingLicense;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.workTime = workTime;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    @Override
    public String toString() {

        return "Driver{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", workTime='" + workTime + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }
}