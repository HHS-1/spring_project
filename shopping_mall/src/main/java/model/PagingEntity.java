package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingEntity {
	String admin_id, search;
	int firstIndex, pagingNumber;
	
	public PagingEntity(String id, int firstIndex, int pagingNumber, String search) {
		this.setAdmin_id(id);
		this.setFirstIndex(firstIndex);
		this.setPagingNumber(pagingNumber);
		this.setSearch(search);
	}
}
