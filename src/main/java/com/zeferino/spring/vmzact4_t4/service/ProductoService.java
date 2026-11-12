package com.zeferino.spring.vmzact4_t4.service;

import com.zeferino.spring.vmzact4_t4.dto.ProductoDTO;
import com.zeferino.spring.vmzact4_t4.model.Producto;
import com.zeferino.spring.vmzact4_t4.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> listar() {
        return productoRepository.findAll().stream()
                .map(p -> new ProductoDTO(p.getId(), p.getNombre(), p.getPrecio()))
                .collect(Collectors.toList());
    }

    public ProductoDTO crear(ProductoDTO dto) {
        Producto producto = new Producto(dto.getNombre(), dto.getPrecio());
        Producto guardado = productoRepository.save(producto);
        return new ProductoDTO(guardado.getId(), guardado.getNombre(), guardado.getPrecio());
    }

    public ProductoDTO obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .map(p -> new ProductoDTO(p.getId(), p.getNombre(), p.getPrecio()))
                .orElse(null);
    }

    public ProductoDTO actualizar(Long id, ProductoDTO dto) {
        return productoRepository.findById(id).map(p -> {
            p.setNombre(dto.getNombre());
            p.setPrecio(dto.getPrecio());
            Producto actualizado = productoRepository.save(p);
            return new ProductoDTO(actualizado.getId(), actualizado.getNombre(), actualizado.getPrecio());
        }).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}