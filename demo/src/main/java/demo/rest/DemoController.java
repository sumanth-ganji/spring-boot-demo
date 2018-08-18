package demo.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.beans.ControlBean;
import demo.beans.DemoResponse;
import demo.dao.ControlRefDAO;

@RestController
public class DemoController {

	@Autowired
	private ControlRefDAO controlRefDAO;
	
	@RequestMapping("/getJobStatus")
	public DemoResponse<ControlBean> getJobStatus(){
		DemoResponse<ControlBean> response = new DemoResponse<ControlBean>();
		ControlBean controlBean = controlRefDAO.getJobStatus();
		
		response.setSuccess(true);
		response.setTotal(1);
		response.setData(controlBean);
		return response;
		
	}
	
	@RequestMapping("/updateJobStatus")
	public DemoResponse<String> updateJobStatus(HttpServletRequest request){
		DemoResponse<String> response = new DemoResponse<String>();
		ControlBean controlBean = new ControlBean();
		String salesDataAggStr = request.getParameter("salesDataAgg");
		try{
			controlBean.setSalesDataAggStatus(Integer.parseInt(salesDataAggStr));
		}catch(NumberFormatException e){
			
		}
		String invDataImportStr = request.getParameter("invDataImport");
		try{
			controlBean.setInvDataImportStatus(Integer.parseInt(invDataImportStr));
		}catch(NumberFormatException e){
			
		}
		String discRuleCalculatorStr = request.getParameter("discRuleCalculator");
		try{
			controlBean.setDiscRuleCalculator(Integer.parseInt(discRuleCalculatorStr));
		}catch(NumberFormatException e){
			
		}
		
		controlBean.setId("job_status");
		
		String resp = controlRefDAO.updateJobStatus(controlBean);
		
		response.setSuccess(true);
		response.setTotal(1);
		response.setData(resp);
		return response;
		
	}
}
