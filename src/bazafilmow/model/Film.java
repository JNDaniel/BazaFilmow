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
public class Film {
    private Long id;
    private String tytul;
    private int rokProdukcji;
    private Double boxOffice;
    private String jezyk;

    public Film() {
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public Double getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(Double boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getJezyk() {
        return jezyk;
    }

    public void setJezyk(String jezyk) {
        this.jezyk = jezyk;
    }

    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", tytul=" + tytul + ", rokProdukcji=" + rokProdukcji + ", boxOffice=" + boxOffice + ", jezyk=" + jezyk + '}';
    }
    
   
    
    
}
