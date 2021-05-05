package sample;

import java.util.List;

public interface InsuranceDao {
    void addInsurance(Insurance insurance);
    void updateInsurance(Insurance insurance);
    void deleteInsurance(Insurance insurance);
    List<Insurance> getAllInsurance();
}
