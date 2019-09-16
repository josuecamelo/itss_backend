package com.josuecamelo.estacionamento;

import java.util.Random;
import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.josuecamelo.estacionamento.enums.VagaStatus;
import com.josuecamelo.estacionamento.models.Cliente;
import com.josuecamelo.estacionamento.models.Cor;
import com.josuecamelo.estacionamento.models.Modelo;
import com.josuecamelo.estacionamento.models.Patio;
import com.josuecamelo.estacionamento.models.Usuario;
import com.josuecamelo.estacionamento.models.Vaga;
import com.josuecamelo.estacionamento.models.Veiculo;
import com.josuecamelo.estacionamento.repositories.ClienteRepository;
import com.josuecamelo.estacionamento.repositories.CorRepository;
import com.josuecamelo.estacionamento.repositories.EstacionamentoRepository;
import com.josuecamelo.estacionamento.repositories.ModeloRepository;
import com.josuecamelo.estacionamento.repositories.PatioRepository;
import com.josuecamelo.estacionamento.repositories.UsuarioRepository;
import com.josuecamelo.estacionamento.repositories.VagaRepository;
import com.josuecamelo.estacionamento.repositories.VeiculoRepository;

@SpringBootApplication
public class EstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}

	/*
	 * Popular Banco Teste
	 * */
	@Bean
	CommandLineRunner init(UsuarioRepository repository, ClienteRepository clienteRepository, 
			ModeloRepository modeloRepository, CorRepository corRepository, PatioRepository patioRepository, 
			VagaRepository vagaRepository, EstacionamentoRepository estacionamentoRepository, VeiculoRepository veiculoRepository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11).mapToObj(i -> {
				Usuario usuario = new Usuario();
				usuario.setNome("Administrador " + i);
				usuario.setLogin("admin" + i);
				usuario.setTelefone("(62) 9999-" + (8000 + i));
				usuario.setSenha("admin" + i);
				return usuario;
			}).map(v -> repository.save(v)).forEach(System.out::println);

			clienteRepository.deleteAll();
			LongStream.range(1, 11).mapToObj(i -> {
				Cliente cliente = new Cliente();
				cliente.setNome("Cliente " + i);
				try {
					cliente.setCpf(geraCPF());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cliente.setTelefone("(62) 98491-" + (8000 + i));
				return cliente;
			}).map(v -> clienteRepository.save(v)).forEach(System.out::println);
			
			modeloRepository.deleteAll();
			LongStream.range(1, 11).mapToObj(i -> {
				Modelo modelo = new Modelo();
				modelo.setNome("Modelo " + i);			
				return modelo;
			}).map(v -> modeloRepository.save(v)).forEach(System.out::println);
			
			corRepository.deleteAll();
			LongStream.range(1, 11).mapToObj(i -> {
				Cor cor = new Cor();
				cor.setNome("Cor " + i);			
				return cor;
			}).map(v -> corRepository.save(v)).forEach(System.out::println);
			
			Patio p1 = new Patio("Pátio 1", 5d);
			Patio p2 = new Patio("Pátio 2", 10d);
			patioRepository.save(p1);
			patioRepository.save(p2);
			
			Vaga v1 = new Vaga(1, p1, VagaStatus.DISPONIVEL);
			Vaga v2 = new Vaga(2, p1, VagaStatus.DISPONIVEL);
			Vaga v3 = new Vaga(3, p1, VagaStatus.DISPONIVEL);
			Vaga v4 = new Vaga(4, p2, VagaStatus.DISPONIVEL);
			vagaRepository.save(v1);
			vagaRepository.save(v2);
			vagaRepository.save(v3);
			vagaRepository.save(v4);
		};
		
		
	}

	public String geraCPF() throws Exception {

		int digito1 = 0, digito2 = 0, resto = 0;
		String nDigResult;
		String numerosContatenados;
		String numeroGerado;

		Random numeroAleatorio = new Random();

		// numeros gerados
		int n1 = numeroAleatorio.nextInt(10);
		int n2 = numeroAleatorio.nextInt(10);
		int n3 = numeroAleatorio.nextInt(10);
		int n4 = numeroAleatorio.nextInt(10);
		int n5 = numeroAleatorio.nextInt(10);
		int n6 = numeroAleatorio.nextInt(10);
		int n7 = numeroAleatorio.nextInt(10);
		int n8 = numeroAleatorio.nextInt(10);
		int n9 = numeroAleatorio.nextInt(10);

		int soma = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

		int valor = (soma / 11) * 11;

		digito1 = soma - valor;

		// Primeiro resto da divisão por 11.
		resto = (digito1 % 11);

		if (digito1 < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		int soma2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

		int valor2 = (soma2 / 11) * 11;

		digito2 = soma2 - valor2;

		// Primeiro resto da divisão por 11.
		resto = (digito2 % 11);

		if (digito2 < 2) {
			digito2 = 0;
		} else {
			digito2 = 11 - resto;
		}

		// Conctenando os numeros
		numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + "." + String.valueOf(n4)
				+ String.valueOf(n5) + String.valueOf(n6) + "." + String.valueOf(n7) + String.valueOf(n8)
				+ String.valueOf(n9) + "-";

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		numeroGerado = numerosContatenados + nDigResult;

		System.out.println("CPF Gerado " + numeroGerado);

		return numeroGerado;
	}// fim do metodo geraCPF
}
