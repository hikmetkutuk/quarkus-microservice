package org.quarkus.resource;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.quarkus.dto.AccountResponse;
import org.quarkus.model.AccountStatus;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Path("/api/v1/account")
public class AccountResource {
    Set<AccountResponse> accounts = new HashSet<>();

    @PostConstruct
    @Path("/setup")
    public void setup() {
        accounts.add(new AccountResponse(123456789L, 123456789L, 987654321L, "George Baird", new BigDecimal("354.23"), AccountStatus.OPEN));
        accounts.add(new AccountResponse(121212121L, 888777666L, 222444999L, "Mary Taylor", new BigDecimal("560.03"), AccountStatus.OPEN));
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<AccountResponse> allAccounts() {
        return accounts;
    }
}
