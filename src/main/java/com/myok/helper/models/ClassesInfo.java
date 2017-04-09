package com.myok.helper.models;

/**
 * Created by sy on 2017/4/9.
 */
public class ClassesInfo {
    private String ClassRoomName;
    private String SchoolId;
    private String SchoolName;
    private String SchoolAddress;
    private Boolean IsBookEnabled;
    private String ScheduleId;
    private String TheDate;
    private String ClassRoomId;
    private Integer BookCount;
    private Integer Seats;
    private String Corpids;
    private String Corpnames;

    public String getClassRoomName() {
        return ClassRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        ClassRoomName = classRoomName;
    }

    public String getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(String schoolId) {
        SchoolId = schoolId;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getSchoolAddress() {
        return SchoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        SchoolAddress = schoolAddress;
    }

    public Boolean getBookEnabled() {
        return IsBookEnabled;
    }

    public void setBookEnabled(Boolean bookEnabled) {
        IsBookEnabled = bookEnabled;
    }

    public String getScheduleId() {
        return ScheduleId;
    }

    public void setScheduleId(String scheduleId) {
        ScheduleId = scheduleId;
    }

    public String getTheDate() {
        return TheDate;
    }

    public void setTheDate(String theDate) {
        TheDate = theDate;
    }

    public String getClassRoomId() {
        return ClassRoomId;
    }

    public void setClassRoomId(String classRoomId) {
        ClassRoomId = classRoomId;
    }

    public Integer getBookCount() {
        return BookCount;
    }

    public void setBookCount(Integer bookCount) {
        BookCount = bookCount;
    }

    public Integer getSeats() {
        return Seats;
    }

    public void setSeats(Integer seats) {
        Seats = seats;
    }

    public String getCorpids() {
        return Corpids;
    }

    public void setCorpids(String corpids) {
        Corpids = corpids;
    }

    public String getCorpnames() {
        return Corpnames;
    }

    public void setCorpnames(String corpnames) {
        Corpnames = corpnames;
    }

    @Override
    public String toString() {
        return "ClassesInfo{" +
                "ClassRoomName='" + ClassRoomName + '\'' +
                ", SchoolId='" + SchoolId + '\'' +
                ", SchoolName='" + SchoolName + '\'' +
                ", SchoolAddress='" + SchoolAddress + '\'' +
                ", IsBookEnabled=" + IsBookEnabled +
                ", ScheduleId='" + ScheduleId + '\'' +
                ", TheDate='" + TheDate + '\'' +
                ", ClassRoomId='" + ClassRoomId + '\'' +
                ", BookCount=" + BookCount +
                ", Seats=" + Seats +
                ", Corpids='" + Corpids + '\'' +
                ", Corpnames='" + Corpnames + '\'' +
                '}';
    }
}
