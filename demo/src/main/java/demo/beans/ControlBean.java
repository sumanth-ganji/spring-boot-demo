package demo.beans;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "control")
public class ControlBean {

	@Field("_id")
	private String id;

	@Field("sales_data_agg")
	private int salesDataAggStatus;

	@Field("inventory_data_import")
	private int invDataImportStatus;

	@Field("disc_rule_calculator")
	private int discRuleCalculator;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSalesDataAggStatus() {
		return salesDataAggStatus;
	}

	public void setSalesDataAggStatus(int salesDataAggStatus) {
		this.salesDataAggStatus = salesDataAggStatus;
	}

	public int getInvDataImportStatus() {
		return invDataImportStatus;
	}

	public void setInvDataImportStatus(int invDataImportStatus) {
		this.invDataImportStatus = invDataImportStatus;
	}

	public int getDiscRuleCalculator() {
		return discRuleCalculator;
	}

	public void setDiscRuleCalculator(int discRuleCalculator) {
		this.discRuleCalculator = discRuleCalculator;
	}

}
