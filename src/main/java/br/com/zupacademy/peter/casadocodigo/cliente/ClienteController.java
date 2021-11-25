package br.com.zupacademy.peter.casadocodigo.cliente;

import br.com.zupacademy.peter.casadocodigo.localizacao.estado.EstadoRepository;
import br.com.zupacademy.peter.casadocodigo.localizacao.pais.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ClienteController {

    private ClienteRepository clienteRepository;
    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;

    public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping(value = "/clientes")
    @Transactional
    public ResponseEntity<ClienteResponse> cadastraCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.toModel(paisRepository, estadoRepository);
        clienteRepository.save(cliente);

        ClienteResponse clienteResponse = new ClienteResponse(cliente);
        return ResponseEntity.ok(clienteResponse);
    }
}