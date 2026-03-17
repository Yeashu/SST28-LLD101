How I solved it:
Separated the fat interface to smaller ones so that objects only have to implement whats required

public interface SmartClassroomDevice {
    // Fat interface (ISP violation) Now changed to just a marker interface
    // void powerOn();
    // void powerOff();
    // void setBrightness(int pct);
    // void setTemperatureC(int c);
    // int scanAttendance();
    // void connectInput(String port);
}

interface Powerable {
    void powerOn();
    void powerOff(); 
}

interface Brightable {
    void setBrightness(int pct);
}

interface ScanAttendance {
    int scanAttendance();
}

interface TempChangeable {
    void setTemperatureC(int c);
}

interface Connectable {
    void connectInput(String port);
}
