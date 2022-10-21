package br.com.java.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.java.spring.data.model.Cargo;
import br.com.java.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	boolean sistema = true;
	
	private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository= cargoRepository;
		}
	public void inicial(Scanner scanner) {
		while (sistema) {
			System.out.println("MENU");
			System.out.println("1-Salvar");
			System.out.println("2-Atualizar");
			System.out.println("3-Excluir");
			System.out.println("-----------");
			
			int action = scanner.nextInt();
			
			if(action == 1) {
				salvar(scanner);
			}else if(action == 2) {
				atualizar(scanner);
			}else if(action == 3){
				deletar(scanner);
			}else {
				sistema = false;
			}
			
		}
	}
	public void  salvar(Scanner scanner) {
		System.out.println("Informe o nome do cargo.");
		String descricaoDoCargo = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricaoDoCargo);
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}
	public void atualizar(Scanner scanner) {
		System.out.println("Informe o id");
		Integer idDoCargo = scanner.nextInt();
		System.out.println("Informe o nome do cargo");
		String descricaoDoCargo = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(idDoCargo);
		cargo.setDescricao(descricaoDoCargo);
		cargoRepository.save(cargo);
		System.out.println("Atualizado");
		
	}
	public void deletar(Scanner scanner) {
		System.out.println("Informe o id");
		Integer idDoCargo = scanner.nextInt();
		
		Cargo cargo = new Cargo();
		cargo.setId(idDoCargo);
		cargoRepository.deleteById(idDoCargo);
		System.out.println("Excluído");
	}
}
