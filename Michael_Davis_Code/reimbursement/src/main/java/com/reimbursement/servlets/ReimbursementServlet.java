package com.reimbursement.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.dao.ReimbursementDao;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;
import com.reimbursement.service.ReimbursementService;


@WebServlet("/reimbursements")
public class ReimbursementServlet extends HttpServlet {
	static ReimbursementService rs=new ReimbursementService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Reimbursement> reimbursements = rs.getAll();
		
	HttpSession session = req.getSession();
		
		User u = (User) session.getAttribute("user");
		ReimbursementDao rere=new ReimbursementDao();
		
		if(u.getUserrole()==2) {
			reimbursements=rere.getUserReimbs(u.getUserid());
		}
		
		ArrayList<ReimThing> rb=new ArrayList<ReimThing>();
		
		//static ReimbursementDao v=new ReimbursementDao();
		if(reimbursements.size()>0) {
			
			for(Reimbursement c:reimbursements) {
				ReimbursementDao jj=new ReimbursementDao();
				int id=c.getId();
				ReimThing holder=new ReimThing();
				String Authorname="";
				double amount=c.getAmount();//done
				String resolver="";//done
				String description=c.getDescription();//done
				String status="";//done
				String type="";//done
				
				//System.out.println("Inside reimbursement loop "+jj.getAuthorName(c.getAuthor()));
				Authorname=jj.getAuthorName(c.getAuthor());
				resolver=jj.getResolverName(c.getResolver());
				
				//System.out.println("author name test final:"+Authorname);
				if(c.getStatusid()==1) {
					status="Pending";
				}
				else if(c.getStatusid()==2) {
					status="Approved";
				}
				else if(c.getStatusid()==3) {
					status="Denied";
				}
				
					if(c.getTypeid()==1) {
						type="Lodging";
					}
					else if(c.getTypeid()==2) {
						type="Travel";
					}
					else if(c.getTypeid()==3) {
						type="Food";
					}
					else if(c.getTypeid()==4) {
						type="Other";
					}
	
				holder.setId(id);
				holder.setAuthorname(Authorname);
				holder.setDescription(description);
				holder.setStatus(status);
				holder.setType(type);
				holder.setAmount(amount);
				holder.setResolver(resolver);
				
				
				//System.out.println("Printing name from holder "+holder.getAuthorname());
				
				rb.add(holder);
				
			}
			 ObjectMapper mapper = new ObjectMapper();
			String json1 = mapper.writeValueAsString(rb);
			
			//System.out.println(json1);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json1);
			
		}else {
			System.out.println("not getting any reimbursements");
			resp.setStatus(404);
		}
		
	
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//get login info from form
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json= "";
		
		
		if(br != null){
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		//System.out.println("BETTER NOT SEE THIS");
		Reimbursement b = mapper.readValue(json, Reimbursement.class);
		System.out.println(b.toString());
		
		b =rs.save(b);
		System.out.println(b.toString());
		
		String ret = mapper.writeValueAsString(b);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(ret);
	}
		
	

}

class ReimThing{
	
	//ReimbursementService rs=new ReimbursementService();
	private int id;
	private String description;
	private String author;
	private String type;
	private String status;
	private String resolver;
	private double amount;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResolver() {
		return resolver;
	}
	public void setResolver(String resolver) {
		this.resolver = resolver;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ReimThing() {
		super();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthorname() {
		return author;
	}
	public void setAuthorname(String a) {
		this.author = a;
		//System.out.println("This.authorname:"+ this.author+"author without this: "+author);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	
		
		
//		PrintWriter out = resp.getWriter();
//		resp.setContentType("application/json");
//		out.write(json);
		
	
	
}
