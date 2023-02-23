package br.unitins.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;    
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.model.Usuario;

@Path("/usuarios")
public class Usuarioresource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> usuarios(){
        return Usuario.findAll().list();
            
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Usuario insert(Usuario usuario){
        usuario.persist();
        
        return usuario;
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Usuario update(@PathParam("id") Long id, Usuario usuario){
        
        Usuario entity = Usuario.findById(id);

        entity.setCpf(usuario.getCpf());
        entity.setNome(usuario.getNome());

        return entity;
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Usuario search(@PathParam("id") Long id) {

        Usuario entity = Usuario.findById(id);

        return entity;
    }
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Usuario del(@PathParam("id") Long id) {

        Usuario entity = Usuario.findById(id);
        entity.delete();
        return entity;
    }


}
