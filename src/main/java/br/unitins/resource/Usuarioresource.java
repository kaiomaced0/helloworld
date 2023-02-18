package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.model.Usuario;

@Path("/usuarios")
public class Usuarioresource {

    @Inject
    Usuario usuario;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> usuarios(){
        try {
            List<Usuario> usuarios = Usuario.findAll().list();
            return usuarios;
        } catch (Exception e) {
            System.out.println("nothing");
            return null;
        }
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Usuario insert(Usuario usuario){
        usuario.persist();
        
        return usuario;
    }
    
}
