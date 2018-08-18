package demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Component;

import demo.beans.ControlBean;

@Component
public class ControlRefDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public ControlBean getJobStatus(){
		
		BasicQuery query = new BasicQuery("{ '_id':'job_status' }");
		ControlBean controlBean = mongoTemplate.findOne(query, ControlBean.class);
		
		System.out.println(controlBean);
		System.out.println("salesDataAgg status: "+controlBean.getSalesDataAggStatus());
		System.out.println("dataImport status: "+controlBean.getInvDataImportStatus());
		System.out.println("discRuleCalc status: "+controlBean.getDiscRuleCalculator());
		
		return controlBean;
	}
	
	public String updateJobStatus(ControlBean controlBean){
		String resp = "Updated the collection";
		
		mongoTemplate.save(controlBean);
		
		return resp;
	}

}
