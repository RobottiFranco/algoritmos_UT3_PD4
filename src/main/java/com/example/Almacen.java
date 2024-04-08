package com.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Almacen implements IAlmacen {

    private String nombre, direccion, telefono;
    private Lista<Producto> listaDeProductos = new Lista<>();

    public Almacen(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public String getDireccion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDireccion'");
    }

    @Override
    public void setDireccion(String direccion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDireccion'");
    }

    @Override
    public String getTelefono() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTelefono'");
    }

    @Override
    public void setTelefono(String telefono) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTelefono'");
    }

    @Override
    public String getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    @Override
    public Lista getListaProductos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListaProductos'");
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        Nodo<Producto> n = new Nodo<Producto>(unProducto.getEtiqueta(), unProducto);
        this.listaDeProductos.insertar(n);
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return this.listaDeProductos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        return this.listaDeProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return this.listaDeProductos.imprimir(separador);

    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Producto p = this.buscarPorCodigo(clave);
        p.agregarStock(cantidad);
        return true;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        Producto p = this.buscarPorCodigo(clave);
        p.restarStock(cantidad);
        return p.getStock();
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        if (this.listaDeProductos.buscar(clave) == null) {
            throw new IllegalArgumentException("El producto no está en la lista");
        }
        return this.listaDeProductos.buscar(clave).getDato();
    }

    @Override
    public void listarOrdenadoPorNombre() {
        Nodo<Producto> actual = listaDeProductos.getPrimero();

        // Convertir la lista enlazada de productos a un ArrayList para ordenar
        ArrayList<Producto> listaProductos = new ArrayList<>();
        while (actual != null) {
            listaProductos.add(actual.getDato());
            actual = actual.getSiguiente();
        }

        // Ordenar el ArrayList usando un comparador basado en los nombres de los
        // productos
        listaProductos.sort(Comparator.comparing(IProducto::getNombre));

        // Imprimir los nombres de los productos ordenados
        System.out.println("Productos ordenados por nombre:");
        for (IProducto producto : listaProductos) {
            System.out.println(producto.getNombre());
        }
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorDescripcion'");
    }

    @Override
    public int cantidadProductos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cantidadProductos'");
    }

    public int obtenerValorStock(Comparable clave) {
        return this.listaDeProductos.buscar(clave).getDato().getStock().intValue();
    }

    public long obtenerValorStock() {

        long result = 0;
        Nodo<Producto> actual = this.listaDeProductos.getPrimero();

        while (actual != null) {
            result += actual.getDato().getPrecio().longValue() * actual.getDato().getStock().longValue();
            actual = actual.getSiguiente();
        }

        return result;
    }

}
