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

import br.unitins.model.Produto;

@Path("/produtos")
public class ProdutoResource {
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> produtos(){
        return Produto.findAll().list();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Produto insert(Produto produto){
        Produto.getEntityManager();
        return produto;
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Produto del(@PathParam("id") Long id) {

        Produto entity = Produto.findById(id);
        entity.delete();
        return entity;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Produto update(@PathParam("id") Long id, Produto produto){
        
        Produto entity = Produto.findById(id);

        entity.setPreco(produto.getPreco());
        entity.setNome(produto.getNome());

        return entity;
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Produto search(@PathParam("id") Long id) {

        Produto entity = Produto.findById(id);

        return entity;
    }



}