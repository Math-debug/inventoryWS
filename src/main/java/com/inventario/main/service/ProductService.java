package com.inventario.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.main.entities.Address;
import com.inventario.main.entities.GroupProduct;
import com.inventario.main.entities.Product;
import com.inventario.main.entities.ProductAddress;
import com.inventario.main.repositories.AddressRepository;
import com.inventario.main.repositories.GroupProductRepository;
import com.inventario.main.repositories.ProductAddressRepository;
import com.inventario.main.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private GroupProductRepository groupProductRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ProductAddressRepository productAddressRepository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

	public Product insert(Product obj) {
		if (obj.getGroupProduct() != null && obj.getGroupProduct().getProductGroupName() != null
				&& obj.getGroupProduct().getIdGroupProduct() == null) {
			List<GroupProduct> groupProduct = groupProductRepository
					.findByProductGroupName(obj.getGroupProduct().getProductGroupName());
			if (groupProduct.isEmpty()) {
				obj.setGroupProduct(groupProductRepository.save(obj.getGroupProduct()));
			} else {
				obj.setGroupProduct(groupProduct.get(0));
			}
		}
		if (obj.getProductAddress() != null && obj.getProductAddress().get(0).getAddress() != null) {
			int x = 0;
			for (ProductAddress address : obj.getProductAddress()) {
				if (address.getAddress() != null && address.getAddress().getIdAddress() == null) {
					List<Address> addressList = addressRepository.findByFullAdress(address.getAddress().getStreet(),
							address.getAddress().getBuilding(), address.getAddress().getApartment(),
							address.getAddress().getLevel());
					if (addressList.isEmpty()) {
						Address addressEntity = new Address(address.getAddress().getStreet(),
								address.getAddress().getBuilding(), address.getAddress().getApartment(),
								address.getAddress().getLevel());
						obj.getProductAddress().get(x).setAddress(addressRepository.save(addressEntity));
					} else {
						obj.getProductAddress().get(x).setAddress(addressList.get(0));
					}
				} else {
					Address addressEntity = addressRepository.findById(address.getAddress().getIdAddress()).get();
					obj.getProductAddress().get(x).setAddress(addressEntity);
				}
				x++;
			}
		}
		Product newProduct = repository.save(obj);
		if(obj.getProductAddress() != null) {
			for (ProductAddress productAddress : obj.getProductAddress()) {
				productAddress.setProduct(newProduct);
				productAddressRepository.save(productAddress);
			}
		}
		return newProduct;
	}
}
