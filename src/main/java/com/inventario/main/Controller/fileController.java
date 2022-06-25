package com.inventario.main.Controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inventario.main.entities.Address;
import com.inventario.main.service.AddressService;

@RestController
@RequestMapping(value = "/file")

public class fileController {
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
		if(!tipoArquivo.equals(".csv")) {
			throw new Exception("arquivo nao suportado");
		}
		FileInputStream stream = (FileInputStream) arquivo.getInputStream();
	    InputStreamReader readerStream = new InputStreamReader(stream);
	    BufferedReader reader = new BufferedReader(readerStream);
	    String linha = reader.readLine();
	    
	    while(linha != null){
	    String[] arrayAddress = linha.split(";");
	    street = arrayAddress[0];
		building=arrayAddress[1];
		apartment=arrayAddress[2];
		level=arrayAddress[3];
		
		Address address = new Address(street,building,apartment,level);
		addressService.insert(address);
		
	     linha = reader.readLine();
	    }
	}
	@PostMapping("/product")
	public void uploadProduct(@RequestParam MultipartFile arquivo) throws Exception {
		
	}
}
