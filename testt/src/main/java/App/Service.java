package App;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EJB.Calculator;

@Stateless
@Path("calculate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class Service {
	@EJB
	Calculator calc;
    @PersistenceContext(unitName="Calculation")
	private EntityManager entityManager;
	
	@POST
	@Path("calc")
	public String performCalc (Calculator c ) {   
		int num1=c.getNumber1();
		int num2=c.getNumber2();
		String op=c.getOperation();
		int r=c.performCalc(num1, num2, op);
		c.setResult(r);
		entityManager.persist(c);
		return "result : " + r;
	}
	
	@GET
	@Path("calculations")
	public List<Calculator> getAllCalculations() {
        TypedQuery<Calculator> query = entityManager.createQuery("select c from Calculator c", Calculator.class);
        List<Calculator> calculations = query.getResultList();
        return calculations;
    }

}
