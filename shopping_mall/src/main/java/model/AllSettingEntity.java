package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllSettingEntity {
	    private int idx_site;              
	    private String admin_id;           
	    private String site_name;          
	    private String admin_email;        
	    private String point_usable;       
	    private int reward;               
	    private int auth_level;            

	    private int idx_company;         
	    private String company_name;       
	    private String business_number;    
	    private String ceo_name;           
	    private String ceo_tel;            
	    private String report_number;
	    private String carrier_number;
	    private String company_post;
	    private String company_address;
	    private String info_manager;
	    private String info_manager_email;
	    
	    private int idx_payment;           
	    private String bank_name;          
	    private String account_number;     
	    private String credit_card_usable; 
	    private String mobile_payment_usable; 
	    private String book_coupon_usable; 
	    private int min_point;             
	    private int max_point;             
	    private String receipt_usable;     
	    private String delivery_company;    
	    private int delivery_fee;         
	    private String delivery_date_usable; 
	
}
