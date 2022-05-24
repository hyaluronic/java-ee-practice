package vu.lt.rest;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Teller;
import vu.lt.persistence.TellersDAO;
import vu.lt.rest.contracts.TellerDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/tellers")
public class TellersController {

    @Inject
    @Setter
    @Getter
    private TellersDAO tellersDAO;

    @Path("/{tellerId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TellerDto getById(@PathParam("tellerId") final Integer tellerId) {
        Teller teller = tellersDAO.findOne(tellerId);
        if (teller == null) {
            throw new EntityNotFoundException("Teller not found");
        }

        TellerDto tellerDto = new TellerDto();
        tellerDto.setName(teller.getName());
        tellerDto.setDepartmentNumber(teller.getDepartment());

        return tellerDto;
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(TellerDto tellerDto) {
        Teller teller = new Teller();
        teller.setName(tellerDto.getName());
        teller.setDepartment(tellerDto.getDepartmentNumber());

        tellersDAO.persist(teller);
        return Response.ok().build();
    }

    @Path("/{tellerId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("tellerId") final Integer tellerId,
            TellerDto tellerData) {
        try {
            Teller existingTeller = tellersDAO.findOne(tellerId);
            if (existingTeller == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingTeller.setName(tellerData.getName());
            existingTeller.setDepartment(tellerData.getDepartmentNumber());
            tellersDAO.update(existingTeller);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
