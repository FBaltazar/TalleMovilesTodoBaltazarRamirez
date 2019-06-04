package com.example.baltarfj_labo_json;

public class AlumnosITT
{
    public int numControl;
    public String nombre;
    public int unidad1;
    public int unidad2;
    public int unidad3;

    public AlumnosITT(int numControl, String nombre, int unidad1, int unidad2, int unidad3)
    {
        this.numControl = numControl;
        this.nombre = nombre;
        this.unidad1 = unidad1;
        this.unidad2 = unidad2;
        this.unidad3 = unidad3;
    }

    public int getNumControl()
    {
        return numControl;
    }

    public void setNumControl(int numControl)
    {
        this.numControl = numControl;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getUnidad1()
    {
        return unidad1;
    }

    public void setUnidad1(int unidad1)
    {
        this.unidad1 = unidad1;
    }

    public int getUnidad2()
    {
        return unidad2;
    }

    public void setUnidad2(int unidad2)
    {
        this.unidad2 = unidad2;
    }

    public int getUnidad3()
    {
        return unidad3;
    }

    public void setUnidad3(int unidad3)
    {
        this.unidad3 = unidad3;
    }

}
