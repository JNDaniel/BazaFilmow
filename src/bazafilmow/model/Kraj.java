/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow.model;

/**
 *
 * @author Daniel
 */
public class Kraj {
    private Long id;
    private String nazwa;

    public Kraj() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Kraj{" + "id=" + id + ", nazwa=" + nazwa + '}';
    }
    
    
    
}
