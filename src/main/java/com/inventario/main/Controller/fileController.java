package com.inventario.main.Controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inventario.main.entities.Address;
import com.inventario.main.entities.GroupProduct;
import com.inventario.main.entities.Product;
import com.inventario.main.entities.ProductAddress;
import com.inventario.main.service.AddressService;
import com.inventario.main.service.ProductService;

@RestController
@RequestMapping(value = "/file")

public class fileController {
	@Autowired
	ProductService productService;
	@Autowired
	AddressService addressService;
	private String street;
	private String building;
	private String apartment;
	private String level;

	@PostMapping("/address")
	public void uploadAddress(@RequestParam MultipartFile arquivo) throws Exception {
		String fileName = arquivo.getOriginalFilename();
		String tipoArquivo = fileName.substring(fileName.indexOf("."));
		if (!tipoArquivo.equals(".csv")) {
			throw new Exception("arquivo nao suportado");
		}
		FileInputStream stream = (FileInputStream) arquivo.getInputStream();
		InputStreamReader readerStream = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(readerStream);
		String linha = reader.readLine();

		while (linha != null) {
			String[] arrayAddress = linha.split(";");
			street = arrayAddress[0];
			building = arrayAddress[1];
			apartment = arrayAddress[2];
			level = arrayAddress[3];

			Address address = new Address(street, building, apartment, level);
			addressService.insert(address);

			linha = reader.readLine();
		}
	}

	@PostMapping("/product")
	public void uploadProduct(@RequestParam MultipartFile arquivo) throws Exception {
		String fileName = arquivo.getOriginalFilename();
		String tipoArquivo = fileName.substring(fileName.indexOf("."));
		if (!tipoArquivo.equals(".csv")) {
			throw new Exception("arquivo nao suportado");
		}
		FileInputStream stream = (FileInputStream) arquivo.getInputStream();
		InputStreamReader readerStream = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(readerStream);
		String linha = reader.readLine();
		while (linha != null) {
			Product product = new Product();
			List<Address> address = new ArrayList<>();
			boolean newProduct = true;
			while (linha != null) {
				String[] arrayParams = linha.split(";");
				if (arrayParams[0].equals("P")) {
					if (newProduct) {
						newProduct = false;
					} else {
						List<ProductAddress> productAddressList = new ArrayList<>();
						for (Address addressFor : address) {
							ProductAddress productAddress = new ProductAddress();
							productAddress.setAddress(addressFor);
							productAddressList.add(productAddress);
						}
						product.setProductAddress(productAddressList);
						productService.insert(product);
						break;
					}
					product.setProductName(arrayParams[1]);
					product.setCodebar(arrayParams[2]);
					product.setGroupProduct(new GroupProduct(arrayParams[3]));
					linha = reader.readLine();
				} else {
					Address add = new Address(street = arrayParams[1], building = arrayParams[2],
							apartment = arrayParams[3], level = arrayParams[4]);
					address.add(add);
					linha = reader.readLine();
				}
			}
		}
	}
}
