package model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class SettingPaymentEntity {
    int idx_payment, min_point, max_point, delivery_fee;
    String admin_id, bank_name, account_number, credit_card_usable, book_coupon_usable, 
           mobile_payment_usable, receipt_usable, delivery_company, delivery_date_usable, in_date;

    public SettingPaymentEntity() {}

    public void setEntity(Map<String, String> dtoData, String id) {
        dtoData.forEach((key, value) -> {
            switch (key) {
                case "bank_name":
                    this.setBank_name(value);
                    break;
                case "account_number":
                    this.setAccount_number(value);
                    break;
                case "credit_card_usable":
                    this.setCredit_card_usable(value);
                    break;
                case "mobile_payment_usable":
                    this.setMobile_payment_usable(value);
                    break;
                case "book_coupon_usable":
                    this.setBook_coupon_usable(value);
                    break;
                case "min_point":
                    this.setMin_point(Integer.parseInt(value));
                    break;
                case "max_point":
                    this.setMax_point(Integer.parseInt(value));
                    break;
                case "receipt_usable":
                    this.setReceipt_usable(value);
                    break;
                case "delivery_company":
                    this.setDelivery_company(value);
                    break;
                case "delivery_fee":
                    this.setDelivery_fee(Integer.parseInt(value));
                    break;
                case "delivery_date_usable":
                    this.setDelivery_date_usable(value);
                    break;
            }
        });

        this.setAdmin_id(id);
    }
}
