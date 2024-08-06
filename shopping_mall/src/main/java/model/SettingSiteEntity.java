package model;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingSiteEntity {
    private int idx_site;
    private int reward;
    private int auth_level;
    private String admin_id;
    private String site_name;
    private String admin_email;
    private String point_usable;
    private String in_date;

    public SettingSiteEntity() {}

    public void setEntity(Map<String, String> dtoData, String id) {
        dtoData.forEach((key, value) -> {
            switch (key) {
                case "site_name":
                    this.setSite_name(value);
                    break;
                case "admin_email":
                    this.setAdmin_email(value);
                    break;
                case "point_usable":
                    this.setPoint_usable(value);
                    break;
                case "reward":
                    this.setReward(Integer.valueOf(value));
                    break;
                case "auth_level":
                    this.setAuth_level(Integer.valueOf(value));
                    break;
            }
        });
        this.setAdmin_id(id);
    }
}
